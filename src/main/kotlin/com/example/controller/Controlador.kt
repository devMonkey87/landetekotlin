package com.example.controller

import com.example.service.TestService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import kotlin.system.measureTimeMillis

@Controller("/")
 class Controlador(private val testService: TestService) {


    @Get("run")
    fun index(): String {

        val valor = 2
        val valor2 = 3


        val tiempoTotal = measureTimeMillis {

            testService.metodoQueCachea(valor)
            var cacheableAVees = testService.metodoQueCachea(valor2)

        }
        println(tiempoTotal)


        val tiempoTotal2 = measureTimeMillis {
            // Código que deseas medir el tiempo de ejecución
            // ...

            testService.metodoQueCachea(valor)
            testService.metodoQueCachea(valor)

        }
        println(tiempoTotal2)





/*
        val metodoCacheable = testService.metodoCacheable()
*/
        return "¡Hola desde TestController!"
    }
}

data class ApiResponse(
    val success: Boolean,
    val data: List<UserData>
)

data class UserData(
    val name: String,
    val role: String,
    val company: String = "",
    val age: Int = 0,
    val scores: List<Int> = emptyList(),
    val createdOn: String = "",
    val description: String = "",
    val verified: Boolean = true
)


