package com.lalo.recyclerviewfragments.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

import com.lalo.recyclerviewfragments.pojo.Contact

import java.util.ArrayList

class DataBase(private val ctx: Context) : SQLiteOpenHelper(ctx, ConstantsDataBase.NAME, null, ConstantsDataBase.VERSION) {
    //String sql = "SELECT * FROM " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + "";
    val contacts: ArrayList<Contact>
        get() {
//            val contacts = ArrayList<Contact>()
//            val sql = "SELECT " + ConstantsDataBase.TABLE_CONTACTS + ".*, IFNULL(Cl." + ConstantsDataBase.TABLE_CONTACT_LIKES_LIKES + ", 0) " +
//                    "FROM " + ConstantsDataBase.TABLE_CONTACTS + " " +
//                    "LEFT JOIN (" +
//                    "SELECT " + ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID + ", COUNT(" + ConstantsDataBase.TABLE_CONTACT_LIKES_LIKES + ") AS " + ConstantsDataBase.TABLE_CONTACT_LIKES_LIKES + " " +
//                    "FROM " + ConstantsDataBase.TABLE_CONTACT_LIKES + " " +
//                    "GROUP BY " + ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID +
//                    ") AS Cl ON " + ConstantsDataBase.TABLE_CONTACTS + "." + ConstantsDataBase.TABLE_CONTACTS_ID + " = Cl." + ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID
//
//            val db = this.readableDatabase
//            val records = db.rawQuery(sql, null)
//            while (records.moveToNext()) {
//                val contact = Contact()
//                contact.id = records.getInt(0)
//                contact.photo = records.getInt(1)
//                contact.name = records.getString(2)
//                contact.phone = records.getString(3)
//                contact.email = records.getString(4)
//                contact.likes = records.getInt(5)
//                contacts.add(contact)
//            }
//            db.close()
//
//            return contacts
            return ArrayList<Contact>()
        }

    override fun onCreate(db: SQLiteDatabase) {
//        val sqlCreateTableContact = "CREATE TABLE " + ConstantsDataBase.TABLE_CONTACTS + "(" +
//                ConstantsDataBase.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                ConstantsDataBase.TABLE_CONTACTS_PHOTO + " INTEGER, " +
//                ConstantsDataBase.TABLE_CONTACTS_NAME + " TEXT, " +
//                ConstantsDataBase.TABLE_CONTACTS_PHONE + " TEXT, " +
//                ConstantsDataBase.TABLE_CONTACTS_EMAIL + " TEXT" +
//                ")"
//
//        val sqlCreateTableContactLikes = "CREATE TABLE " + ConstantsDataBase.TABLE_CONTACT_LIKES + "(" +
//                ConstantsDataBase.TABLE_CONTACT_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
//                ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID + " INTEGER, " +
//                ConstantsDataBase.TABLE_CONTACT_LIKES_LIKES + " INTEGER, " +
//                "FOREIGN KEY (" + ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID + ") " +
//                "REFERENCES " + ConstantsDataBase.TABLE_CONTACTS + "(" + ConstantsDataBase.TABLE_CONTACTS_ID + ")" +
//                ")"
//
//        db.execSQL(sqlCreateTableContact)
//        db.execSQL(sqlCreateTableContactLikes)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
//        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.TABLE_CONTACTS)
//        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.TABLE_CONTACT_LIKES)
//
//        this.onCreate(db)
    }

    fun getLikesByContact(contact: Contact): Int {
//        var likes = 0
//        val db = this.readableDatabase
//        val sql = "SELECT COUNT(" + ConstantsDataBase.TABLE_CONTACT_LIKES_LIKES + ") " +
//                "FROM " + ConstantsDataBase.TABLE_CONTACT_LIKES + " " +
//                "WHERE " + ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID + " = ?"
//
//        val records = db.rawQuery(sql, arrayOf("" + contact.id))
//
//        if (records.moveToNext()) {
//            likes = records.getInt(0)
//        }
//
//        db.close()
//
//        return likes
        return 0
    }

    fun insertContact(contact: Contact) {
//        val values = ContentValues()
//        values.put(ConstantsDataBase.TABLE_CONTACTS_PHOTO, contact.photo)
//        values.put(ConstantsDataBase.TABLE_CONTACTS_NAME, contact.name)
//        values.put(ConstantsDataBase.TABLE_CONTACTS_PHONE, contact.phone)
//        values.put(ConstantsDataBase.TABLE_CONTACTS_EMAIL, contact.email)
//
//        val db = this.writableDatabase
//        db.insert(ConstantsDataBase.TABLE_CONTACTS, null, values)
//        db.close()
    }

    fun insertLike(contact: Contact) {
//        val values = ContentValues()
//        values.put(ConstantsDataBase.TABLE_CONTACT_LIKES_CONTACT_ID, contact.id)
//        values.put(ConstantsDataBase.TABLE_CONTACT_LIKES_LIKES, contact.likes)
//
//        val db = this.writableDatabase
//        db.insert(ConstantsDataBase.TABLE_CONTACT_LIKES, null, values)
//        db.close()
    }
}