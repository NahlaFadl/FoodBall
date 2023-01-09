package com.example.testfoodball.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfoodball.adapter.CompetitionAdapter
import com.example.testfoodball.R
import com.example.testfoodball.view_model.CompetitionViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    lateinit var competitionViewModel: CompetitionViewModel
    val competationAdatpter = CompetitionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        competitionViewModel = ViewModelProvider(this).get(CompetitionViewModel::class.java)
        runBlocking { competitionViewModel.getCompetition() }


        // fun to observe the change on data
        getData()
        //to init recycler
        recyclerInt()
    }
    // fun to observe the change on data and pass data to recycler
    fun getData(){
        competitionViewModel.mutableLiveData?.observe(this, Observer { t->
            competationAdatpter.setList(t)
        })
    }
    //to init recycler
    fun recyclerInt(){
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler.adapter = competationAdatpter
    }

}