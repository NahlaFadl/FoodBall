package com.example.testfoodball.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testfoodball.Response
import com.example.testfoodball.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback

class CompetitionViewModel:ViewModel() {

    var mutableLiveData:MutableLiveData<Response>? = MutableLiveData()

  suspend  fun getCompetition(){
        val call= ApiClient.instance!!.getMyApi().getCompetitions()
        call.enqueue(object :Callback<Response>{
            override fun onResponse(
                call: Call<Response>?,
                response: retrofit2.Response<Response>?
            ) {
                mutableLiveData!!.value=response!!.body()
            }

            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                Log.d("ero",t!!.message.toString())
            }

        })
    }
}