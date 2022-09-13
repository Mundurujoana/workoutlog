package dev.mundu.workoutlog.api

import dev.mundu.workoutlog.models.LoginRequest
import dev.mundu.workoutlog.models.LoginResponse
import dev.mundu.workoutlog.models.RegisterRequest
import dev.mundu.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/login")
  suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
}

//make network calls,