package com.example.newyorkcity

import android.content.Context
import android.net.Uri
import java.io.File
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

data class NameUriPair(val name: String, val uri: String)

class StorageBox(private val context: Context) {
    private val gson = Gson()
    private val fileName = "name_uri_pairs.json"
    private val file = File(context.filesDir, fileName)

    fun saveSound(sound: Sound) {
        println(sound.getUri().toString())
        val pair = NameUriPair(sound.getName(), sound.getUri().toString())
        val json = gson.toJson(listOf(pair))
        file.writeText(json)
    }

    fun loadSounds(): List<Sound> {
        if (!file.exists()) return emptyList()

        val json = file.readText()
        println(json)
        val typeToken = object : TypeToken<List<NameUriPair>>() {}.type
        println("after made typeToken")
        val loadedPairs: List<NameUriPair> = gson.fromJson(json, typeToken)
        println("after loaded pairs is made using gson")
        val soundList = mutableListOf<Sound>()
        println("for each")
        loadedPairs.forEach {soundPair ->
            println("Sound name: ${soundPair.name}, URI: ${soundPair.uri}")
            val sound = Sound(soundPair.name, uri = Uri.parse(soundPair.uri))
            soundList.add(sound)
        }
        return soundList
    }

}