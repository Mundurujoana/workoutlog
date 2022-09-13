package dev.mundu.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mundu.workoutlog.models.ExerciseCategory
import dev.mundu.workoutlog.repository.ExerciseRepository
import kotlinx.coroutines.launch

class ExerciseViewModel:ViewModel() {
    val exerciseRepository = ExerciseRepository()
    val exerciseCategoryLiveData = MutableLiveData<List<ExerciseCategory>>()
    val errorLiveData = MutableLiveData<String?>()

    fun fetchExerciseCategories(accessToken: String){
        viewModelScope.launch {
            val response = exerciseRepository.fetchExerciseCategories(accessToken)
            if(response.isSuccessful){
                exerciseCategoryLiveData.postValue(response.body())
            }
            else{
                val errorMsg = response.errorBody()?.string()
                errorLiveData.postValue(errorMsg)
            }

        }
    }

}