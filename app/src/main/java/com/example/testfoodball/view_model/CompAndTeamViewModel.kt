package com.example.testfoodball.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testfoodball.Response2
import com.example.testfoodball.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompAndTeamViewModel:ViewModel() {

    val mutableLiveDataComAndTeam:MutableLiveData<Response2> = MutableLiveData()

   suspend fun getDetailsCompAndTeam(){
        val call= ApiClient.instance?.getMyApi()?.getCompetitionAndTeam()
        call?.enqueue(object : Callback<Response2>{
            override fun onResponse(call: Call<Response2>?, response: Response<Response2>?) {
                mutableLiveDataComAndTeam.value = response?.body()
            }

            override fun onFailure(call: Call<Response2>?, t: Throwable?) {
                Log.d("ero2",t?.message.toString())
            }

        })
    }
}