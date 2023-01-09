package com.example.testfoodball.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfoodball.adapter.CompAndTeamAdapter
import com.example.testfoodball.R
import com.example.testfoodball.view_model.CompAndTeamViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.runBlocking


class SecondActivity : AppCompatActivity() {

    val compAndTeamAdapter = CompAndTeamAdapter()
    lateinit var compAndTeamViewModel: CompAndTeamViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        compAndTeamViewModel = ViewModelProvider(this).get(CompAndTeamViewModel::class.java)
       runBlocking { compAndTeamViewModel.getDetailsCompAndTeam() }


        // fun to observe the change on data
        getCompAndTemData()
        //to init recycler
        recyclerInIt()
    }

    //to init recycler
    private fun recyclerInIt() {
        recycle_second.layoutManager = LinearLayoutManager(this)
        recycle_second.adapter = compAndTeamAdapter
    }
    // fun to observe the change on data and pass data to recycler
    fun getCompAndTemData(){
        compAndTeamViewModel.mutableLiveDataComAndTeam.observe(this, Observer { it->

            //to get competition data
            com_name.text=it.name
            txt_code.text=it.code
            Picasso.get().load(it.emblemUrl).into(com_image)
            txt_start.text=it.currentSeason.startDate
            txt_end.text=it.currentSeason.endDate

            //to full team recycler
            compAndTeamAdapter.setList2(it)
        })
    }
}