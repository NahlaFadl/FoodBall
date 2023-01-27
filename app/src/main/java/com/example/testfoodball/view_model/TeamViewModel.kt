package com.example.testfoodball.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testfoodball.MainRepository
import com.example.testfoodball.Response3
import com.example.testfoodball.utils.NetworkHelper
import com.example.testfoodball.utils.Resourse
import kotlinx.coroutines.launch
//import com.example.testfoodball.data.repository.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamViewModel(private val mainRepository: MainRepository,
                    private val networkHelper: NetworkHelper):ViewModel() {

    var mutableLiveDataTeam = MutableLiveData<Resourse<Response3>>()
    val liveDataTeam:LiveData<Resourse<Response3>>
    get() = mutableLiveDataTeam

    init {
        fetchTeam()
    }

    private fun fetchTeam() {
        viewModelScope.launch {
            mutableLiveDataTeam.postValue(Resourse.loading(null))
            if (networkHelper.isNetworkConnected()){
                mainRepository.geTeam().let {
                    if (it.isSuccessful){
                        mutableLiveDataTeam.postValue(Resourse.success(it.body()))
                    }else{
                        mutableLiveDataTeam.postValue(Resourse.error(it.errorBody().toString(),null))
                    }
                }
            }else{
                mutableLiveDataTeam.postValue(Resourse.error("No internet connection",null))
            }
        }
    }
}