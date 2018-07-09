package com.lalo.recyclerviewfragments.restApi.Deserializer

import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.lalo.recyclerviewfragments.pojo.Contact
import com.lalo.recyclerviewfragments.restApi.JsonKeys
import com.lalo.recyclerviewfragments.restApi.model.ContactResponse

import java.lang.reflect.Type
import java.util.ArrayList

class ContactDeserializer : JsonDeserializer<ContactResponse> {
    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): ContactResponse {
        val gson = Gson()
        val cr = gson.fromJson(json, ContactResponse::class.java)
        val data = json.asJsonObject.getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY)
        cr.lstContacts = deserializerContactsFromJson(data)
        return cr
    }

    fun deserializerContactsFromJson(data: JsonArray): ArrayList<Contact> {
        val lstContacts = ArrayList<Contact>()
        var contact: Contact? = null
        for (i in 0 until data.size()) {
            contact = Contact()

            val cr = data.get(i).asJsonObject
            val user = cr.getAsJsonObject(JsonKeys.USER)
            contact.id = user.get(JsonKeys.USER_ID).asString
            contact.username = user.get(JsonKeys.USER_NAME).asString

            val image = cr.getAsJsonObject(JsonKeys.MEDIA_IMAGES)
            val imageStdResolution = image.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION)
            contact.urlPhoto = imageStdResolution.get(JsonKeys.MEDIA_URL).asString

            val likes = cr.getAsJsonObject(JsonKeys.MEDIA_LIKES)
            contact.likes = likes.get(JsonKeys.MEDIA_LIKES_COUNT).asInt

            lstContacts.add(contact)
        }

        return lstContacts
    }
}
