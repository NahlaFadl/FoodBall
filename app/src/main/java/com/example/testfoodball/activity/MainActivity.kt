package com.example.testfoodball.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testfoodball.adapter.CompetitionAdapter
import com.example.testfoodball.R
import com.example.testfoodball.utils.Status
import com.example.testfoodball.view_model.CompetitionViewModel
import kotlinx.android.synthetic.main.activity_main.*
//import org.koin.android.viewmodel.ext.android.viewModel
//import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.androidx.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {

    private val competitionViewModel: CompetitionViewModel by viewModel()
    var competationAdatpter = CompetitionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //to init recycler
        recyclerInt()
//        setupUI()
        setupObserver()
    }

    private fun setupObserver(){
        competitionViewModel.liveData.observe(this, Observer {
            when(it.status){
                Status.SUCCESS->{
                    progressBar.visibility= View.GONE
                    it.data.let {
                            response-> response?.let { it1 -> competationAdatpter.setList(it1) } }
                    recycler.visibility=View.VISIBLE
                }
                Status.LOADING->{
                    progressBar.visibility = View.VISIBLE
                    recycler.visibility = View.GONE
                }
                Status.ERROR->{
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    //to init recycler
    fun recyclerInt(){
        recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        recycler.adapter = competationAdatpter
    }
}