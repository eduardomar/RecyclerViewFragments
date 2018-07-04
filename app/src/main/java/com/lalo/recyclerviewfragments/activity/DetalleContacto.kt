package com.lalo.recyclerviewfragments.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.lalo.recyclerviewfragments.R
import com.lalo.recyclerviewfragments.pojo.Contact
import android.app.AlertDialog

class DetalleContacto : AppCompatActivity() {
    private val MY_PERMISSIONS_REQUEST_CALL_PHONE: Int = 1
    private val MY_REQUEST_CALL_PHONE: Int = 2
    private val tvNameContact: TextView by lazy { this.findViewById(R.id.tvNameContact) as TextView }
    private val tvPhoneContact: TextView by lazy { this.findViewById(R.id.tvPhoneContact) as TextView }
    private val tvEmailContact: TextView by lazy { this.findViewById(R.id.tvEmailContact) as TextView }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contacto)

        val contact = this.intent.extras!!.getParcelable<Contact>("Contacto")
        this.tvNameContact.text = contact.name
        this.tvPhoneContact.text = contact.phone
        this.tvEmailContact.text = contact.email
    }

    fun call(v: View) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_DENIED) { // Revisamos el status del permiso
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) { // Vemos si el permiso ya se habia solicitado
                showExplanation("Permission needed", "You need access to calls")
            } else {
                requestPermission()
            }
        }

        call()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_CALL_PHONE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "El permiso fue otorgado", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "El permiso no fue otorgado", Toast.LENGTH_SHORT).show()
                }

                call()
                return
            }
        }
    }

    private fun call() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) { // Revisamos el status del permiso
            startActivityForResult(Intent(Intent.ACTION_CALL, Uri.parse("tel:" + this.tvPhoneContact.text.toString())), MY_REQUEST_CALL_PHONE)
        }
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CALL_PHONE), MY_PERMISSIONS_REQUEST_CALL_PHONE);
    }

    private fun showExplanation(title: String, message: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, DialogInterface.OnClickListener { dialog, id -> requestPermission() })
        builder.create().show()
    }

    fun sendEmail(v: View) {
        val i = Intent(Intent.ACTION_SEND)
        i.data = Uri.parse("mailto:")
        i.putExtra(Intent.EXTRA_EMAIL, this.tvEmailContact.getText().toString())
        i.type = "message/rfc822"
        startActivity(Intent.createChooser(i, "Email "))
    }
}