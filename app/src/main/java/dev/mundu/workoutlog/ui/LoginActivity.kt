package dev.mundu.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.mundu.workoutlog.databinding.ActivityLoginBinding
import dev.mundu.workoutlog.models.LoginRequest
import dev.mundu.workoutlog.models.LoginResponse
<<<<<<< HEAD
import dev.mundu.workoutlog.utils.Constants
=======
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
import dev.mundu.workoutlog.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        is a keyvalue store
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            validateForm()
            finish()
        }
        binding.tvSignup.setOnClickListener {
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume(){
        super.onResume()
        userViewModel.loginResponseLivedata.observe(this, Observer {loginResponse->
            saveLoginDetails(loginResponse!!)
            Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        })
        userViewModel.loginErrorliveData.observe(this, Observer{ error->
        Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
        })
    }

    private fun validateForm() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error = false

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (!error) {
            val loginRequest = LoginRequest(email, password)
            binding.pbLogin.visibility = View.VISIBLE
            userViewModel.loginUser(loginRequest)

        }
    }

    fun saveLoginDetails(loginResponse: LoginResponse){
<<<<<<< HEAD
        val editor = sharedPrefs.edit()
        val token = "Bearer ${loginResponse.accessToken}"
       )
        editor.putString(Constants.accessToken, loginResponse.accessToken)
        editor.putString(Constants.useId, loginResponse.userId)
        editor.putString(Constants.profileId, loginResponse.profileId)
=======
val editor = sharedPrefs.edit()
        editor.putString("ACCESS_TOKEN", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.accessToken)
        editor.putString("USER_ID", loginResponse.userId)
        editor.putString("PROFILE_ID", loginResponse.profileId)
>>>>>>> f4f2612b1ac57d7ba002a23e85483bc7e2336bc4
        editor.apply()
    }
}