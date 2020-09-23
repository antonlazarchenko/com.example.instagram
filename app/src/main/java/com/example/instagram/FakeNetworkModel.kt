package com.example.instagram

import android.content.Context
import com.google.gson.Gson
import java.io.InputStream


class FakeNetworkModel {

    fun getFakeData(context: Context): Map<String, String>? {
        val inputStream: InputStream = context.resources.assets.open("fakedata.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        val jsonString = String(buffer)

        println(jsonString)

        val gson = Gson()
        return gson.fromJson<Map<String, String>>(jsonString, MutableMap::class.java)
    }

}