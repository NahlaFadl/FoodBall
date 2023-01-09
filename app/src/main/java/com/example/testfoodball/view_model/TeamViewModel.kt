package com.example.testfoodball.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testfoodball.Response3
import com.example.testfoodball.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamViewModel:ViewModel() {

    var mutableLiveDataTeam:MutableLiveData<Response3> = MutableLiveData()

   suspend fun getTeamDetails(){
        val call= ApiClient.instance?.getMyApi()?.geTeam()
        call?.enqueue(object : Callback<Response3>{
            override fun onResponse(call: Call<Response3>?, response: Response<Response3>?) {
                mutableLiveDataTeam.value=response?.body()
            }

            override fun onFailure(call: Call<Response3>?, t: Throwable?) {
                Log.d("ero3",t?.message.toString())
            }

        })
    }
}