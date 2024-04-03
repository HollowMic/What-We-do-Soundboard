package com.example.newyorkcity

import android.content.Context
import android.media.MediaPlayer

class MediaController(private val context: Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.you_really_are_the_most_devious_bastard_in_new_york_city)

    fun playSound(path: Int) {
        mediaPlayer.apply {
            stop()
            release()
        }
        if (path != 0) {
            mediaPlayer = MediaPlayer.create(context, path)
            mediaPlayer.start()
        } else {
            mediaPlayer = MediaPlayer.create(context, R.raw.you_really_are_the_most_devious_bastard_in_new_york_city)
        }
    }
}