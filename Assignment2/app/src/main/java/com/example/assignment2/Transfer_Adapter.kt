package com.example.assignment2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class Transfer_Adapter(var playerlist : ArrayList<String>, // names
                       var playerimage : ArrayList<Int>,   // photos
                       var playerPer : ArrayList<Int>, // percentage
                       var transfere : ArrayList<Int>,
                       var context: Context)
    : RecyclerView.Adapter<Transfer_Adapter.TransferViewHolder>()

{
    class TransferViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val playerImage: ImageView = itemView.findViewById(R.id.playerImage)
        val playerName: TextView = itemView.findViewById(R.id.player_Name)
        val percentage: ImageView = itemView.findViewById(R.id.percentage)
        val cardView: CardView = itemView.findViewById(R.id.card)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransferViewHolder {
        val view:View = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_design,parent,false)

        return TransferViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerlist.size
    }

    override fun onBindViewHolder(holder: TransferViewHolder, position: Int) {
        holder.playerName.text = playerlist.get(position)
        holder.playerImage.setImageResource(playerimage.get(position))
        holder.percentage.setImageResource(playerPer.get(position))

        holder.cardView.setOnClickListener {
            val intent = Intent(context,Player_Info::class.java)

            intent.putExtra("playerName", holder.playerName.text)
            intent.putExtra("playerImage", playerimage[position])
            intent.putExtra("transfer",transfere[position])

            context.startActivity(intent)

        }
    }


}
