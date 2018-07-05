package com.lalo.recyclerviewfragments.db

import android.content.Context

import com.lalo.recyclerviewfragments.R
import com.lalo.recyclerviewfragments.pojo.Contact

import java.util.ArrayList

class ConstructorContacts(private val ctx: Context) {
    val data: ArrayList<Contact>
        get() {
            //val lstContacts = ArrayList<Contact>()
            //return lstContacts
            val db = DataBase(ctx)
//            db.insertContact(Contact(0, R.drawable.ic_tongue_emoticon, "Eduardo Ramírez", "445 104 61 86", "eramirez@freshsoftwareconcepts.com", 0))
//            db.insertContact(Contact(0, R.drawable.ic_confused_emoticon, "Carlos Fuentes", "+1 (520) 245-2866", "cfuentes@freshsoftware.co", 0))
//            db.insertContact(Contact(0, R.drawable.ic_love_emoticon, "Enrique Noriega", "+1 (520) 245-2866", "enrique@freshsoftware.co", 0))
//            db.insertContact(Contact(0, R.drawable.ic_mute_emoticon, "Javier Barajas", "445 108 5650", "javierbarajas@freshsoftwareconcepts.com", 0))
//            db.insertContact(Contact(0, R.drawable.ic_tired_emoticon, "Huberto Luna", "662 338 2046", "uluna@freshsoftwareconcepts.com", 0))
            return db.contacts
        }

    fun giveLike(contact: Contact) {
        val db = DataBase(ctx)
        db.insertLike(contact)
    }

    fun getLikes(contact: Contact): Int {
        val db = DataBase(ctx)
        return db.getLikesByContact(contact)
    }
}