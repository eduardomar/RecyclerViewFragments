package com.lalo.recyclerviewfragments.adapter

import android.app.Activity
import android.content.Intent
import android.support.annotation.NonNull
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.lalo.recyclerviewfragments.R
import com.lalo.recyclerviewfragments.activity.DetalleContacto
import com.lalo.recyclerviewfragments.db.ConstructorContacts
import com.lalo.recyclerviewfragments.pojo.Contact
import java.util.ArrayList

class ContactAdapter(private val contacts: ArrayList<Contact>, private val activity: Activity) : RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview_contacto, parent, false)

        return ContactViewHolder(v)
    }

    override fun getItemCount(): Int { // Cantidad de elementos que contiene mi lista
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, index: Int) { // Asocia cada elemento de la lista con cada view
        val contact = this.contacts[index]
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val _tvContacto by lazy { itemView.findViewById<CardView>(R.id.tvContacto) }
        private val _imgFoto by lazy { itemView.findViewById<ImageView>(R.id.imgFoto) }
        private val _tvLikes by lazy { itemView.findViewById<TextView>(R.id.tvLikes) }
        private val _imgBone by lazy { itemView.findViewById<ImageView>(R.id.imgBone) }

        val tvContacto get() = this._tvContacto
        val imgFoto get() = this._imgFoto
        val tvLikes get() = this._tvLikes
        val imgBone get() = this._imgBone
    }
}