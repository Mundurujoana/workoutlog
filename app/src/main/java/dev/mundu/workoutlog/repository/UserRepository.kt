package dev.mundu.workoutlog.repository

import dev.mundu.workoutlog.api.ApiClient
import dev.mundu.workoutlog.api.ApiInterface
import dev.mundu.workoutlog.models.LoginRequest
import dev.mundu.workoutlog.models.RegisterRequest
<<<<<<< HEAD
import dev.mundu.workoutlog.models.ProfileRequest
=======
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun loginUser(loginRequest: LoginRequest)=
        withContext(Dispatchers.IO) {
            var response = apiClient.login(loginRequest)
            return@withContext response
<<<<<<< HEAD
=======

>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
        }

    suspend fun registerUser(registerRequest: RegisterRequest)=
        withContext(Dispatchers.IO) {
<<<<<<< HEAD
            return@withContext apiClient.registerUser(registerRequest)
        }

    suspend fun profileUser(profileRequest: ProfileRequest)=
        withContext(Dispatchers.IO) {
            return@withContext apiClient.profile(profileRequest)
        }

=======
            var response = apiClient.registerUser(registerRequest)
            return@withContext response

        }


>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
}