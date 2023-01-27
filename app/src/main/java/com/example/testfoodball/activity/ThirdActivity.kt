package com.example.testfoodball.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.testfoodball.R
import com.example.testfoodball.utils.Status
import com.example.testfoodball.view_model.TeamViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_third.*
import kotlinx.coroutines.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ThirdActivity : AppCompatActivity() {

    private val teamViewModel: TeamViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        val Id:Int=intent.extras?.getInt("id")!!.toInt()

//         fun to observe the change on data
        getTeamsData(Id)
    }

//     fun to observe the change on data
    fun getTeamsData(Id:Int){
        teamViewModel.liveDataTeam.observe(this, Observer { it->

            when(it.status){
                Status.SUCCESS->{
                    progressBar3.visibility=View.GONE
                    it.data.let {
                        val count=it!!.count-1
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

                    }
                    appBar.visibility=View.VISIBLE
                    nestedScroll.visibility=View.VISIBLE
                }
                Status.LOADING->{
                    progressBar3.visibility=View.VISIBLE
                    appBar.visibility=View.GONE
                    nestedScroll.visibility=View.GONE
                }
                Status.ERROR->{
                    progressBar3.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }

        })
    }

}