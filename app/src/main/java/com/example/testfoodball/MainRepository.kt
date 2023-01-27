package com.example.testfoodball

import com.example.testfoodball.data.repository.retrofit.ApiHelper
import retrofit2.Response

class MainRepository(private val apiHelper: ApiHelper) {

    suspend fun getCompetitions(): Response<Response1> = apiHelper.getCompetitions()
    suspend fun getCompetitionAndTeam(): Response<Response2> = apiHelper.getCompetitionAndTeam()
    suspend fun geTeam(): Response<Response3> = apiHelper.geTeam()
}