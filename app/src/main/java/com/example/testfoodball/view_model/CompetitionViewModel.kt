package com.example.testfoodball.view_model

//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
import com.example.testfoodball.Response1
import com.example.testfoodball.MainRepository
import com.example.testfoodball.utils.NetworkHelper
import com.example.testfoodball.utils.Resourse
import kotlinx.coroutines.launch

import androidx.lifecycle.*

class CompetitionViewModel(
    private val mainRepository: MainRepository,
    val networkHelper: NetworkHelper):ViewModel() {

   private val mutableLiveData:MutableLiveData<Resourse<Response1>> = MutableLiveData()

    val liveData: MutableLiveData<Resourse<Response1>>
    get() = mutableLiveData

    init {
        fetchCompetition()
    }

    private fun fetchCompetition() {

        viewModelScope.launch {
            mutableLiveData.postValue(Resourse.loading(null))
            if (networkHelper.isNetworkConnected()){
                mainRepository.getCompetitions().let {
                    if (it.isSuccessful){
                        mutableLiveData.postValue(Resourse.success(it.body()))
                    }else{
                        mutableLiveData.postValue(Resourse.error(it.errorBody().toString(),null))
                    }

                }
            }else{
                mutableLiveData.postValue(Resourse.error("No internet connection",null))
            }
        }
    }


}