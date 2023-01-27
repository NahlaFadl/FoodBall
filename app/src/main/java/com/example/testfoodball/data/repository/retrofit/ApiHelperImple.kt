package com.example.testfoodball.data.repository.retrofit

import com.example.testfoodball.Response1
import com.example.testfoodball.Response2
import com.example.testfoodball.Response3
import retrofit2.Call
import retrofit2.Response

class ApiHelperImple(private val api: API): ApiHelper {
    override suspend fun getCompetitions(): Response<Response1> = api.getCompetitions()

    override suspend fun getCompetitionAndTeam(): Response<Response2> = api.getCompetitionAndTeam()


    override suspend fun geTeam(): Response<Response3> = api.geTeam()
}