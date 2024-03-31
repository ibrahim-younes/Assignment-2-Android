package com.example.assignment2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class Player_Info : AppCompatActivity() {

    lateinit var playerName :TextView
    lateinit var date_data :TextView
    lateinit var age_data :TextView
    lateinit var nationality_data :TextView
    lateinit var height_data :TextView
    lateinit var contract_data :TextView
    lateinit var position_data :TextView
    lateinit var foot_data :TextView
    lateinit var current_data :TextView
    lateinit var interested_data :TextView
    lateinit var player_Img : ImageView
    lateinit var logo_img : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_info)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        playerName = findViewById(R.id.playerName)
        player_Img  = findViewById(R.id.player_Img)
        logo_img =findViewById(R.id.club_trans)

        var PlayerName:String = intent.getStringExtra("playerName").toString()
        var playerImage = intent.getIntExtra("playerImage", 0)
        var trans = intent.getIntExtra("transfer",0)

        playerName.text = PlayerName
        player_Img.setImageResource(playerImage)
        logo_img.setImageResource(trans)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar items
        return when (item.itemId) {
            android.R.id.home -> {
                // Handle the Up button press
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}