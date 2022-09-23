package dev.mundu.workoutlog.api

<<<<<<< HEAD
import dev.mundu.workoutlog.models.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
=======
import dev.mundu.workoutlog.models.LoginRequest
import dev.mundu.workoutlog.models.LoginResponse
import dev.mundu.workoutlog.models.RegisterRequest
import dev.mundu.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest):Response<RegisterResponse>

    @POST("/login")
<<<<<<< HEAD
    suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>

    @POST("/profile")
    suspend fun profile(@Body profileRequest: ProfileRequest):Response<ProfileResponse>

    @GET("/exercise-categories")
    suspend fun fetchExerciseCategories(@Header("Authorization") accessToken: String): Response<List<ExerciseCategory>>
    //header some additional infomation
=======
  suspend fun login(@Body loginRequest: LoginRequest):Response<LoginResponse>
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
}

//make network calls,