package com.example.service

import com.squareup.okhttp.*
import io.micronaut.cache.annotation.CacheConfig
import io.micronaut.cache.annotation.Cacheable
import jakarta.inject.Singleton

@Singleton
@CacheConfig("micache")
public open class TestService {


/*    fun metodoCacheable(): Any? {
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
        return ApiResponse(true, listOf(UserData("d","sds" , "s")))
    }*/


    @Cacheable()
    public open fun metodoQueCachea(valor: Int): String {
        println("se ejdcuta el cacheableeee" + valor)
        return "pues si"
    }



}

