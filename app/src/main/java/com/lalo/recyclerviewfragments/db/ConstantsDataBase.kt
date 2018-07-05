package com.lalo.recyclerviewfragments.db

object ConstantsDataBase {
    val NAME                           = "Contactos"
    val VERSION                        = 1
    val TABLE_CONTACTS                 = "contact"
    val TABLE_CONTACTS_ID              = "id"
    val TABLE_CONTACTS_PHOTO           = "photo"
    val TABLE_CONTACTS_NAME            = "name"
    val TABLE_CONTACTS_PHONE           = "phone"
    val TABLE_CONTACTS_EMAIL           = "email"

    val TABLE_CONTACT_LIKES            = "contact_likes"
    val TABLE_CONTACT_LIKES_ID         = "id"
    val TABLE_CONTACT_LIKES_CONTACT_ID = "contactID"
    val TABLE_CONTACT_LIKES_LIKES      = "numLikes"
}