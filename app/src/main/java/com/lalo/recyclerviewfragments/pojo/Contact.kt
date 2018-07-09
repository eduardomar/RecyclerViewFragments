package com.lalo.recyclerviewfragments.pojo

import android.os.Parcel
import android.os.Parcelable

class Contact : Parcelable {
    public var id: String
        get() = field
        set(value) {
            field = value
        }
    public var username: String
        get() = field
        set(value) {
            field = value
        }
    public var urlPhoto: String
        get() = field
        set(value) {
            field = value
        }
    public var likes: Int
        get() = field
        set(value) {
            field = value
        }

    constructor() : this("", "", "", 0) {
    }

    constructor(id: String, username: String, urlPhoto: String, likes: Int) {
        this.id = id
        this.username = username
        this.urlPhoto = urlPhoto
        this.likes = likes
    }

    constructor(pa: Parcel) : this(pa.readString(), pa.readString(), pa.readString(), pa.readInt()) {}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(this.id)
        parcel.writeString(this.username)
        parcel.writeString(this.urlPhoto)
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