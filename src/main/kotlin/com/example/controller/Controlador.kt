package com.example.controller

import com.example.service.TestService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class Controlador(private val testService: TestService) {


    @Get("run")
    fun index(): String {
        val valor = 2
        val valor2 = 3

        var resultadito = testService.metodoQueCachea(valor)
        println("OK QUE PASO ??" + resultadito)

        var resultadito2 = testService.metodoQueCachea(valor2)
        println("OK QUE PASO 2 ??" + resultadito2)

        var resultadito3 = testService.metodoQueCachea(valor)
        println("OK QUE PASO  3??" + resultadito3)

        var resultadito4 = testService.metodoQueCachea(valor2)
        println("OK QUE PASO  4??" + resultadito4)

        return "¡Hola desde TestController!"
    }
}

data class ApiResponse(
    val success: Boolean, val data: List<UserData>
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


