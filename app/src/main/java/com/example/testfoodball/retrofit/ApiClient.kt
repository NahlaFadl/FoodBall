package com.example.testfoodball.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient private constructor() {
    private val myApi: API
    fun getMyApi(): API {
        return myApi
    }
    companion object {
        @get:Synchronized
        var instance: ApiClient? = null
            get() {
                if (field == null) {
                    field = ApiClient()
                }
                return field
            }
            private set
    }

    init {
        val retrofit: Retrofit =
            Retrofit.Builder().baseUrl("http://api.football-data.org/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        myApi = retrofit.create(API::class.java)
    }
}