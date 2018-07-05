package com.lalo.recyclerviewfragments.adapter

import android.app.Activity
import android.content.Intent
import android.support.annotation.NonNull
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

        return  ContactViewHolder(v)
    }

    override fun getItemCount(): Int { // Cantidad de elementos que contiene mi lista
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, index: Int) { // Asocia cada elemento de la lista con cada view
        val contact = this.contacts[index]

        holder.imgPhotoContact.setImageResource(contact.photo)
        holder.imgPhotoContact.setOnClickListener {
            Toast.makeText(activity, contact.name, Toast.LENGTH_SHORT).show()
            val i = Intent(activity, DetalleContacto::class.java)
            i.putExtra("Contacto", contact)

            activity.startActivity(i)
        }
        holder.tvNameContact.text = contact.name
        holder.tvPhoneContact.text = contact.phone
        holder.btnLike.setOnClickListener {
            val cc = ConstructorContacts(activity)
            cc.giveLike(contact)
            holder.tvLikesContact.text = cc.getLikes(contact).toString() + " likes"

            Toast.makeText(activity, "Le diste like a " + contact.name, Toast.LENGTH_SHORT).show()
        }
        holder.tvLikesContact.text = contact.likes.toString() + " likes"
    }

    class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val _imgPhotoContact: ImageView by lazy { itemView.findViewById(R.id.imgPhotoContact) as ImageView }
        private val _tvNameContact: TextView by lazy { itemView.findViewById(R.id.tvNameContact) as TextView }
        private val _tvPhoneContact: TextView by lazy { itemView.findViewById(R.id.tvPhoneContact) as TextView }
        private val _btnLike: ImageButton by lazy { itemView.findViewById(R.id.btnLike) as ImageButton }
        private val _tvLikesContact: TextView by lazy { itemView.findViewById(R.id.tvLikesContact) as TextView }

        val imgPhotoContact get() = this._imgPhotoContact
        val tvNameContact get() = this._tvNameContact
        val tvPhoneContact get() = this._tvPhoneContact
        val btnLike get() = this._btnLike
        val tvLikesContact get() = this._tvLikesContact
    }
}