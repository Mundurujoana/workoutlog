package dev.mundu.workoutlog.repository

import dev.mundu.workoutlog.api.ApiClient
import dev.mundu.workoutlog.api.ApiInterface
import dev.mundu.workoutlog.models.LoginRequest
import dev.mundu.workoutlog.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest)=
        withContext(Dispatchers.IO) {
            var response = apiClient.login(loginRequest)
            return@withContext response

        }

    suspend fun registerUser(registerRequest: RegisterRequest)=
        withContext(Dispatchers.IO) {
            var response = apiClient.registerUser(registerRequest)
            return@withContext response

        }


}