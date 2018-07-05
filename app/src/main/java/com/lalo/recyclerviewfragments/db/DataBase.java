package com.lalo.recyclerviewfragments.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.lalo.recyclerviewfragments.pojo.Contact;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {
    private Context ctx;

    public DataBase(Context ctx) {
        super(ctx, ConstantsDataBase.INSTANCE.getNAME(), null, ConstantsDataBase.INSTANCE.getVERSION());
        this.ctx = ctx;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableContact = "CREATE TABLE " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + "(" +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_ID() + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_PHOTO() + " INTEGER, " +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_NAME() + " TEXT, " +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_PHONE() + " TEXT, " +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_EMAIL() + " TEXT" +
                ")";

        String sqlCreateTableContactLikes = "CREATE TABLE " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES() + "(" +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_ID() + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID() + " INTEGER, " +
                ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_LIKES() + " INTEGER, " +
                "FOREIGN KEY (" + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID() + ") " +
                "REFERENCES " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + "(" + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_ID() + ")" +
                ")";

        db.execSQL(sqlCreateTableContact);
        db.execSQL(sqlCreateTableContactLikes);
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS());
        db.execSQL("DROP TABLE IF EXIST " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES());

        this.onCreate(db);
    }

    public ArrayList<Contact> getContacts() {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        //String sql = "SELECT * FROM " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + "";
        String sql = "SELECT " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + ".*, IFNULL(Cl." + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_LIKES() + ", 0) " +
                "FROM " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + " " +
                "LEFT JOIN (" +
                "SELECT " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID() + ", COUNT(" + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_LIKES() + ") AS " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_LIKES() + " " +
                "FROM " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES() + " " +
                "GROUP BY " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID() +
                ") AS Cl ON " + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS() + "." + ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_ID() +" = Cl." + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor records = db.rawQuery(sql, null);
        while (records.moveToNext()) {
            Contact contact = new Contact();
            contact.setId(records.getInt(0));
            contact.setPhoto(records.getInt(1));
            contact.setName(records.getString(2));
            contact.setPhone(records.getString(3));
            contact.setEmail(records.getString(4));
            contact.setLikes(records.getInt(5));
            contacts.add(contact);
        }
        db.close();

        return contacts;
    }

    public int getLikesByContact(Contact contact) {
        int likes = 0;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT COUNT(" + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_LIKES() + ") " +
                "FROM " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES() + " " +
                "WHERE " + ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID() + " = ?";

        Cursor records = db.rawQuery(sql, new String[]{"" + contact.getId()});

        if (records.moveToNext()) {
            likes = records.getInt(0);
        }

        db.close();

        return likes;
    }

    public void insertContact(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_PHOTO(), contact.getPhoto());
        values.put(ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_NAME(), contact.getName());
        values.put(ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_PHONE(), contact.getPhone());
        values.put(ConstantsDataBase.INSTANCE.getTABLE_CONTACTS_EMAIL(), contact.getEmail());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDataBase.INSTANCE.getTABLE_CONTACTS(), null, values);
        db.close();
    }

    public void insertLike(Contact contact) {
        ContentValues values = new ContentValues();
        values.put(ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_CONTACT_ID(), contact.getId());
        values.put(ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES_LIKES(), contact.getLikes());

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantsDataBase.INSTANCE.getTABLE_CONTACT_LIKES(), null, values);
        db.close();
    }
}