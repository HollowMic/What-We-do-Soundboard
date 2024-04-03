package com.example.newyorkcity

class Sound(
    private val name: String,
    private val path: Int
) {

    fun getName(): String {
        return name
    }

    fun getPath(): Int {
        return path
    }
}