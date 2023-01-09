package com.example.testfoodball.retrofit

import com.example.testfoodball.Response
import com.example.testfoodball.Response2
import com.example.testfoodball.Response3
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface API {
    @GET("competitions")
    @Headers("Accept: application/json","X-Auth-Token:87d8928e168f4149b3ea9d89501ba603")
    fun getCompetitions():Call<Response>

    @GET("competitions/2000")
    @Headers("Accept: application/json","X-Auth-Token:87d8928e168f4149b3ea9d89501ba603")
    fun getCompetitionAndTeam():Call<Response2>

    @GET("competitions/2000/teams")
    @Headers("Accept: application/json","X-Auth-Token:87d8928e168f4149b3ea9d89501ba603")
    fun geTeam():Call<Response3>
}