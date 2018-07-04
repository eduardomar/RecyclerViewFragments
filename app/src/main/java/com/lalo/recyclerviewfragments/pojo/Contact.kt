package com.lalo.recyclerviewfragments.pojo

import android.os.Parcel
import android.os.Parcelable

class Contact : Parcelable {
    public var photo: Int
        get() = field
        set(value) {
            field = value
        }
    public var name: String
        get() = field
        set(value) {
            field = value
        }
    public var phone: String
        get() = field
        set(value) {
            field = value
        }
    public var email: String
        get() = field
        set(value) {
            field = value
        }

    constructor(photo: Int, name: String, phone: String, email: String) {
        this.photo = photo
        this.name = name
        this.phone = phone
        this.email = email
    }

    constructor(pa: Parcel) : this(pa.readInt(), pa.readString(), pa.readString(), pa.readString()) { }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(this.photo)
        parcel.writeString(this.name)
        parcel.writeString(this.phone)
        parcel.writeString(this.email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contact> {
        override fun createFromParcel(parcel: Parcel): Contact {
            return Contact(parcel)
        }

        override fun newArray(size: Int): Array<Contact?> {
            return arrayOfNulls(size)
        }
    }
}