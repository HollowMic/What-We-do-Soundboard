package com.example.newyorkcity

import android.net.Uri

class Sound(
    private val name: String,
    private val path: Int = 0,
    private val uri: Uri = Uri.Builder().build()
) {

    fun getName(): String {
        return name
    }

    fun getPath(): Int {
        return path
    }

    fun getUri(): Uri {
        return uri
    }
}