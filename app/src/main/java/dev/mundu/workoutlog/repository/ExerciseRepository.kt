package dev.mundu.workoutlog.repository

import dev.mundu.workoutlog.api.ApiClient
import dev.mundu.workoutlog.api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExerciseRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun fetchExerciseCategories(accessToken: String)=
        withContext(Dispatchers.IO){
            return@withContext apiClient.fetchExerciseCategories(accessToken)
        }
}