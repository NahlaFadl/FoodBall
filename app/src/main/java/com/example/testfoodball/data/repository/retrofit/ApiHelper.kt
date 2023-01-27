package com.example.testfoodball.data.repository.retrofit


import com.example.testfoodball.Response1
import com.example.testfoodball.Response2
import com.example.testfoodball.Response3
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiHelper {

    suspend fun getCompetitions(): Response<Response1>

    suspend fun getCompetitionAndTeam(): Response<Response2>

    suspend fun geTeam(): Response<Response3>
}