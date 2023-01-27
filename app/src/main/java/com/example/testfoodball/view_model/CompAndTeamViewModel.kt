package com.example.testfoodball.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testfoodball.MainRepository
import com.example.testfoodball.Response2
import com.example.testfoodball.utils.NetworkHelper
import com.example.testfoodball.utils.Resourse
import kotlinx.coroutines.launch
//import com.example.testfoodball.data.repository.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompAndTeamViewModel(private val mainRepository: MainRepository,
                           private val networkHelper: NetworkHelper):ViewModel() {

    val mutableLiveDataComAndTeam= MutableLiveData<Resourse<Response2>>()

    val liveDataComAndTeam:LiveData<Resourse<Response2>>

    get() = mutableLiveDataComAndTeam

    init {
        fetchComAndTeam()
    }

    private fun fetchComAndTeam() {
        viewModelScope.launch {
            mutableLiveDataComAndTeam.postValue(Resourse.loading(null))
            if (networkHelper.isNetworkConnected()){
                mainRepository.getCompetitionAndTeam().let {
                    if (it.isSuccessful){
                        mutableLiveDataComAndTeam.postValue(Resourse.success(it.body()))
                    }else{
                        mutableLiveDataComAndTeam.postValue(Resourse.error(it.errorBody().toString(),null))
                    }
                }
            }else{
                mutableLiveDataComAndTeam.postValue(Resourse.error("No internet connection",null))
            }
        }
    }

}