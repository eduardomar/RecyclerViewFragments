package com.lalo.recyclerviewfragments.restApi

/**
 * Created by anahisalgado on 25/05/16.
 */
object ConstantsRestApi {
    //https://api.instagram.com/v1/
    const val VERSION = "/v1/"
    const val ROOT_URL = "https://api.instagram.com$VERSION"
    const val ACCESS_TOKEN = "3259702353.aa0d0f4.e61865afc9144ecc8ffc8f6dc84aa17b"
    const val KEY_ACCESS_TOKEN = "?access_token="
    const val KEY_GET_RECENT_MEDIA_USER = "users/self/media/recent/"
    const val URL_GET_RECENT_MEDIA_USER = KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=ACCESS-TOKEN
}