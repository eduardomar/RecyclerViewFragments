package com.lalo.recyclerviewfragments.pojo

import android.os.Parcel
import android.os.Parcelable

class Contact : Parcelable {
    public var id: Int
        get() = field
        set(value) {
            field = value
        }
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
    public var likes: Int
        get() = field
        set(value) {
            field = value
        }

    constructor() : this(0, 0, "", "", "", 0) {
    }

    constructor(id: Int, photo: Int, name: String, phone: String, email: String, likes: Int) {
        this.id = id
        this.photo = photo
        this.name = name
        this.phone = phone
        this.email = email
        this.likes = likes
    }

    constructor(pa: Parcel) : this(pa.readInt(), pa.readInt(), pa.readString(), pa.readString(), pa.readString(), pa.readInt()) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(this.id)
        parcel.writeInt(this.photo)
        parcel.writeString(this.name)
        parcel.writeString(this.phone)
        parcel.writeString(this.email)
        parcel.writeInt(this.likes)
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