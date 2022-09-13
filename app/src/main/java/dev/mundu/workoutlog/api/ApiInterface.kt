package dev.mundu.workoutlog.api

import dev.mundu.workoutlog.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/login")
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>

    @POST("/profile")
    suspend fun profile(@Body profileRequest: ProfileRequest):Response<ProfileResponse>

    @GET("/exercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization") accessToken: String): Response<List<ExerciseCategory>>
    //header some additional infomation
}

//make network calls,