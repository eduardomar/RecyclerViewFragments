package com.lalo.recyclerviewfragments.restApi.adapter

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.lalo.recyclerviewfragments.restApi.ConstantsRestApi
import com.lalo.recyclerviewfragments.restApi.Deserializer.ContactDeserializer
import com.lalo.recyclerviewfragments.restApi.EndpointsApi
import com.lalo.recyclerviewfragments.restApi.model.ContactResponse
import com.squareup.picasso.Picasso

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiAdapter {
    fun setConnectionRestApiInstagram(gson: Gson): EndpointsApi {
        val ret = Retrofit.Builder()
                .baseUrl(ConstantsRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        return ret.create(EndpointsApi::class.java)
    }

    fun buildGsonDeserializerMediaRecent(): Gson {
        val gb = GsonBuilder()
        gb.registerTypeAdapter(ContactResponse::class.java, ContactDeserializer())

        return gb.create()
    }
}