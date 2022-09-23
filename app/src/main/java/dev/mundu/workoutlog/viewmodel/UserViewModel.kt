package dev.mundu.workoutlog.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
<<<<<<< HEAD
import dev.mundu.workoutlog.models.*
import dev.mundu.workoutlog.repository.UserRepository
=======
import dev.mundu.workoutlog.repository.UserRepository
import dev.mundu.workoutlog.models.LoginRequest
import dev.mundu.workoutlog.models.LoginResponse
import dev.mundu.workoutlog.models.RegisterRequest
import dev.mundu.workoutlog.models.RegisterResponse
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
//    val loginResponseLiveData: Any
    val userRepository = UserRepository()
    val loginResponseLivedata = MutableLiveData<LoginResponse>()
    val loginErrorliveData = MutableLiveData<String?>()
    var registerResponseLiveData=MutableLiveData<RegisterResponse>()
    val registerErrorLiveData=MutableLiveData<String?>()
<<<<<<< HEAD
    var profileResponseLiveData=MutableLiveData<ProfileResponse>()
    val profileErrorLiveData=MutableLiveData<String?>()
=======
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4

    fun loginUser(loginRequest: LoginRequest){
        viewModelScope.launch{
            val response = userRepository.loginUser(loginRequest)
            if(response.isSuccessful){
                loginResponseLivedata.postValue(response.body())
            }
            else{
                val error = response.errorBody()?.string()
<<<<<<< HEAD
             loginErrorliveData.postValue(error)
=======
             loginErrorliveData.postValue(response.errorBody()?.string())
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
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
<<<<<<< HEAD
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
=======
                registerErrorLiveData.postValue(response.errorBody()?.string())
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
            }
        }
    }

}