package com.lalo.recyclerviewfragments.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.TextView
import com.lalo.recyclerviewfragments.R
import com.lalo.recyclerviewfragments.pojo.Contact

class DetalleContacto : AppCompatActivity() {
    private val tvNameContact: TextView by lazy { this.findViewById(R.id.tvNameContact) as TextView }
    private val tvPhoneContact: TextView by lazy { this.findViewById(R.id.tvPhoneContact) as TextView }
    private val tvEmailContact: TextView by lazy { this.findViewById(R.id.tvEmailContact) as TextView }
    //private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contacto)

        val contact = this.intent.extras!!.getParcelable<Contact>("Contacto")
        this.tvNameContact.text = contact.name
        this.tvPhoneContact.text = contact.phone
        this.tvEmailContact.text = contact.email
    }

    fun call(v: View) {
    }

    fun sendEmail(v: View) {
    }
}