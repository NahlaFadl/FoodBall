package com.example.testfoodball.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testfoodball.R
//import com.example.testfoodball.Response
import com.example.testfoodball.Response1
import com.example.testfoodball.activity.SecondActivity
import com.example.testfoodball.utils.Resourse
import kotlinx.android.synthetic.main.cometation_item.view.*

class CompetitionAdapter : RecyclerView.Adapter<CompetitionAdapter.CompetitionViewHolder>() {
    var competitionList: List<Response1> = ArrayList<Response1>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        return CompetitionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cometation_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        holder.comTitle.text=competitionList[position].competitions[position].area.name
        holder.comTitle2.text=competitionList[position].competitions[position].area.countryCode
        holder.teamName.text=competitionList[position].competitions[position].name.toString()
        holder.currentMatch.text =competitionList[position].competitions[position].currentSeason?.currentMatchday?.toString()

        //to intent to second activity
        holder.itemView.setOnClickListener {
            val context:Context=holder.teamName.context
            if(competitionList[position].competitions[position].id==2000) {
                val intent = Intent(context, SecondActivity::class.java)
                context.startActivity(intent)
            }else{
                Toast.makeText(context,"You must pay for this id",Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return competitionList.size
    }

    fun setList(competition: Response1) {
        val list:ArrayList<Response1> = ArrayList()
        val size:Int =competition?.count!!.toInt()
        for (n in 1 .. size){
            list.add(competition)
        }
        this.competitionList = list
        notifyDataSetChanged()
    }

    inner class CompetitionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var comTitle: TextView
        var comTitle2: TextView
        var teamName: TextView
        var currentMatch: TextView

        init {
            comTitle = itemView.com_title as TextView
            comTitle2 = itemView.com_titl2 as TextView
            teamName = itemView.teamName as TextView
            currentMatch=itemView.curntMatch as TextView
        }
    }
}
