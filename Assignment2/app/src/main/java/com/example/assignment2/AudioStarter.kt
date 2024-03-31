package com.example.assignment2

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer

class AudioStarter : IntentService("AudioStarter") {
    override fun onHandleIntent(intent: Intent?) {
        val mp = MediaPlayer.create(applicationContext, R.raw.come_alive)
        mp.start()
    }
}
