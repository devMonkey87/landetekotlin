package com.example.controller

import com.example.service.TestService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class Controlador {

    private val testService: TestService = TestService()

    @Get("run")
    fun index(): String {
        val metodoCacheable = testService.metodoCacheable()
        return "¡Hola desde TestController!" + metodoCacheable
    }
}

data class ApiResponse(
    val success: Boolean,
    val data: List<UserData>
)

data class UserData(
    val name: String,
    val role: String,
    val company: String,
    val age: Int,
    val scores: List<Int>,
    val createdOn: String,
    val description: String,
    val verified: Boolean
)


