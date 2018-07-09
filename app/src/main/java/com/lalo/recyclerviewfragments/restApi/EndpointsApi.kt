package com.lalo.recyclerviewfragments.restApi

import com.lalo.recyclerviewfragments.restApi.model.ContactResponse

import retrofit2.Call
import retrofit2.http.GET

interface EndpointsApi {
    @get:GET(ConstantsRestApi.URL_GET_RECENT_MEDIA_USER)
    val recentMedia: Call<ContactResponse>
}