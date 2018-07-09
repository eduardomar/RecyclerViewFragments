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
import android.support.v7.widget.CardView
import android.widget.ImageView
import com.squareup.picasso.Picasso

class DetalleContacto : AppCompatActivity() {
    private val imgFotoDetalle by lazy { this.findViewById<ImageView>(R.id.imgFotoDetalle) }
    private val tvLikesDetalle by lazy { this.findViewById<TextView>(R.id.tvLikesDetalle) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_contacto_foto)

        val contact = this.intent.extras!!.getParcelable<Contact>("Contacto")
        Picasso.get().load(contact.urlPhoto)
                .placeholder(R.drawable.ic_love_emoticon)
                .into(imgFotoDetalle)

        this.tvLikesDetalle.text = contact.likes.toString()
    }
}