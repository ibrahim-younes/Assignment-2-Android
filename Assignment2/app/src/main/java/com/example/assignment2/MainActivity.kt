package com.example.assignment2

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var receiver: Receiver
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:Transfer_Adapter


    var playerlist = ArrayList<String>()
    var playerimage = ArrayList<Int>()
    var playerPer = ArrayList<Int>()
    var transfere = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //................................................................start audio
        val intent = Intent(this, AudioStarter::class.java)
        startService(intent)

        recyclerView = findViewById(R.id.recycle_view)

        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

        playerlist.add("Messi")
        playerlist.add("MoSalah")
        playerlist.add("zlatan")

        playerimage.add(R.drawable.messi)
        playerimage.add(R.drawable.mosalah)
        playerimage.add(R.drawable.zlatan)

        playerPer.add(R.drawable.im2)
        playerPer.add(R.drawable.lv2)
        playerPer.add(R.drawable.chel2)

        transfere.add(R.drawable.messi_transf)
        transfere.add(R.drawable.moh_transf)
        transfere.add(R.drawable.zalt_transf)


        adapter = Transfer_Adapter(playerlist,playerimage,playerPer,transfere,this@MainActivity)

        recyclerView.adapter = adapter

    }


    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "Application resumed", Toast.LENGTH_SHORT).show();
    }

    override fun onStart() {
        super.onStart()

        receiver = Receiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(receiver, it)
        }

    }
    override fun onStop() {
        super.onStop()

        unregisterReceiver(receiver)
    }

}