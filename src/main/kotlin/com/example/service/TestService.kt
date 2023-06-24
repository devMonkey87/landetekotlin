package com.example.service

import com.example.controller.ApiResponse
import com.example.controller.UserData
import com.google.gson.Gson
import com.squareup.okhttp.*
import jakarta.inject.Singleton

@Singleton
class TestService {


    fun execute(): String {

        println("funcionooooooooooo")
        return "hello frm service"
    }

    fun metodoCacheable(): Any? {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://random-chunk-api.p.rapidapi.com/api/name?startingLetter=X&count=2")
            .get()
            .addHeader("X-RapidAPI-Key", "94ee14ffabmshfbfd83af1fe237ep166202jsn5bd8d48365f2")
            .addHeader("X-RapidAPI-Host", "random-chunk-api.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()

        if (response.isSuccessful) {
            println("ha ido ok")
            val responseString = response.body()?.string()
            if (responseString != null) {

                println("no nula")
                val gson = Gson()
                val apiResponse = gson.fromJson(responseString, ApiResponse::class.java)
                // ahora `apiResponse` es un objeto que contiene los datos de tu respuesta

                println("aaa"+responseString)
                return apiResponse
            }
        }
        return null
    }


}

