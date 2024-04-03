package com.example.newyorkcity

import android.content.Context
import java.io.File
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class StorageBox(private val context: Context) {
    private val gson = Gson()
    private val fileName = "name_uri_pairs.json"
    private val file = File(context.filesDir, fileName)

    fun saveSound(sound: Sound) {
        val json = gson.toJson(sound.getName())
        json.plus(sound.getUri())
        file.writeText(json)
    }

    fun loadSounds(): List<Sound> {
        if (!file.exists()) return emptyList()

        val json = file.readText()
        val typeToken = object : TypeToken<List<Sound>>() {}.type
        return gson.fromJson(json, typeToken)
    }

}