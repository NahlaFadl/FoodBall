package com.example.testfoodball.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfoodball.adapter.CompAndTeamAdapter
import com.example.testfoodball.R
import com.example.testfoodball.utils.Status
import com.example.testfoodball.view_model.CompAndTeamViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel


class SecondActivity : AppCompatActivity() {

    val compAndTeamAdapter = CompAndTeamAdapter()
    private val compAndTeamViewModel: CompAndTeamViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

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
        compAndTeamViewModel.liveDataComAndTeam.observe(this, Observer { it->

            when(it.status){
                Status.SUCCESS->{
                    progressBar2.visibility= View.GONE

                    it.data.let {
                        //to get competition data
                        com_name.text=it?.name
                        txt_code.text=it?.code
                        Picasso.get().load(it?.emblemUrl).into(com_image)
                        txt_start.text=it?.currentSeason?.startDate
                        txt_end.text=it?.currentSeason?.endDate
                        //to full team recycler
                        compAndTeamAdapter.setList2(it)
                        recycle_second.visibility=View.VISIBLE
                        cardView.visibility=View.VISIBLE
                    }

                }
                Status.LOADING->{
                    progressBar2.visibility=View.VISIBLE
                    recycle_second.visibility=View.GONE
                    cardView.visibility=View.GONE
                }
                Status.ERROR->{
                    progressBar2.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }


        })
    }
}