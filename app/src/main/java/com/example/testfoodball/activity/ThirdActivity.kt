package com.example.testfoodball.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testfoodball.R
import com.example.testfoodball.view_model.TeamViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.coroutines.*

class ThirdActivity : AppCompatActivity() {

    lateinit var teamViewModel: TeamViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val Id:Int=intent.extras?.getInt("id")!!.toInt()

        teamViewModel=ViewModelProvider(this@ThirdActivity).get(TeamViewModel::class.java)
        runBlocking { teamViewModel.getTeamDetails() }

        // fun to observe the change on data
        getTeamsData(Id)
    }

    // fun to observe the change on data
    fun getTeamsData(Id:Int){
        teamViewModel.mutableLiveDataTeam.observe(this, Observer { it->
            val count=it.count-1
            for ( i in 0..count){
                if (it.teams[i].id==Id){
                    Picasso.get().load(it.teams[i].crestUrl).into(image_team)
                    nameOfTem.text=it.teams[i].name
                    team_phone.text=it.teams[i].phone
                    txt_email.text=it.teams[i].email
                    txt_website.text=it.teams[i].website
                    txt_clubColors.text=it.teams[i].clubColors
                    break
                }
            }
        })
    }

}