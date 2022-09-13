package dev.mundu.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mundu.workoutlog.models.*
import dev.mundu.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
//    val loginResponseLiveData: Any
    val userRepository = UserRepository()
    val loginResponseLivedata = MutableLiveData<LoginResponse>()
    val loginErrorliveData = MutableLiveData<String?>()
    var registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val registerErrorLiveData=MutableLiveData<String?>()
    var profileResponseLiveData=MutableLiveData<ProfileResponse>()
    val profileErrorLiveData=MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response = userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginResponseLivedata.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
             loginErrorliveData.postValue(error)
            }
        }
    }

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch{
            val response = userRepository.registerUser(registerRequest)
            if(response.isSuccessful){
                registerResponseLiveData.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }
    fun profileUser(profileRequest: ProfileRequest){
        viewModelScope.launch{
            val response = userRepository.profileUser(profileRequest)
            if(response.isSuccessful){
                profileResponseLiveData.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
                profileErrorLiveData.postValue(error)
            }
        }
    }

}