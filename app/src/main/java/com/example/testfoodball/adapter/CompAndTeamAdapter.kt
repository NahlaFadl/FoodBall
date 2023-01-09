package com.example.testfoodball.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testfoodball.R
import com.example.testfoodball.Response2
import com.example.testfoodball.activity.ThirdActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.competition_team_item.view.*

class CompAndTeamAdapter:RecyclerView.Adapter<CompAndTeamAdapter.CompAndTeamViewHolder>() {
    var teamList:ArrayList<Response2> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompAndTeamViewHolder {
        return CompAndTeamViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.competition_team_item,parent,false))
    }

    override fun onBindViewHolder(holder: CompAndTeamViewHolder, position: Int) {
        holder.teamName.text=teamList[position].seasons[position]?.winner?.name
        holder.teamShortName.text=teamList[position]!!.seasons[position]?.winner?.shortName
        Picasso.get().load(teamList[position]!!.seasons[position]?.winner?.crestUrl).into(holder.teamImage)

        // to intent to third Activity
        val context:Context=holder.teamName.context
        holder.itemView.setOnClickListener {
            val id=teamList[position].seasons[position]?.winner?.id
            if (id!=null) {
                val intent = Intent(context, ThirdActivity::class.java)
                intent.putExtra("id", teamList[position].seasons[position].winner.id)
                context.startActivity(intent)
            }
            else{Toast.makeText(context,"nod data",Toast.LENGTH_LONG).show()}
        }
    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    fun setList2(teams: Response2?){
        val list:ArrayList<Response2> = ArrayList()
        for (n in 1 .. 22){
            list.add(teams!!)
        }
        this.teamList=list
        notifyDataSetChanged()
    }
    class CompAndTeamViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

        var teamImage:ImageView
        var teamName:TextView
        var teamShortName:TextView
        init {
            teamImage=itemView.team_image as ImageView
            teamName=itemView.team_name as TextView
            teamShortName=itemView.team_shortName as TextView
        }
    }
}