package com.example.newyorkcity

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri

class MediaController(private val context: Context) {

    private var mediaPlayer: MediaPlayer = MediaPlayer.create(context, R.raw.you_really_are_the_most_devious_bastard_in_new_york_city)

    fun playSound(sound: Sound) {
        mediaPlayer.apply {
            stop()
            release()
        }
        if (sound.getPath() != 0) {
            mediaPlayer = MediaPlayer.create(context, sound.getPath())
            mediaPlayer.start()
        } else if (sound.getUri() != Uri.Builder().build()) {
            mediaPlayer = MediaPlayer.create(context, sound.getUri())
            mediaPlayer.start()
        } else {
                mediaPlayer = MediaPlayer.create(context, R.raw.you_really_are_the_most_devious_bastard_in_new_york_city)
        }
    }
}