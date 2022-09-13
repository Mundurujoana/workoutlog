package dev.mundu.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.mundu.workoutlog.databinding.ActivitySignupBinding
import dev.mundu.workoutlog.models.RegisterRequest
import dev.mundu.workoutlog.models.RegisterResponse
import dev.mundu.workoutlog.api.ApiClient
import dev.mundu.workoutlog.api.ApiInterface
import dev.mundu.workoutlog.viewmodel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignupBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs = getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            valRegistraionForm()

        }


        binding.tvLogin.setOnClickListener {
            val intent= Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
    override fun onResume() {
        super.onResume()
        userViewModel.loginResponseLivedata.observe(this, Observer { registerResponse->
            Toast.makeText(baseContext,registerResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LoginActivity::class.java))
        })
        userViewModel.loginErrorliveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }


    fun valRegistraionForm() {
        var firstname = binding.etFirstname.text.toString()
        var lastname = binding.etLastname.text.toString()
        var email = binding.etEmail1.text.toString()

        var error = false
        if (firstname.isBlank()) {
            binding.tilFirstname.error = "Firstname required"
        }
        if (lastname.isBlank()) {
            binding.tilLastname.error = "second name required"

        }
        if (email.isBlank()) {
            binding.tilEmail1.error = "Email reuired"
        }

        var password1 = binding.etPassword1.text.toString()
        var password2 = binding.etPassword2.text.toString()
        if (password1.isBlank()) {
            binding.tilPassword1.error = "confirm password"
        } else {
            binding.tilPassword1.error = null

        }
        if (password2.isBlank()) {
            binding.tilPassword2.error = "Password is required"
        }
        if (password1 == password2) {
            binding.btnSignup
        } else {
            binding.tilPassword2.error="Invalid password"
        }

        if(!error){
           val registerRequest = RegisterRequest(firstname, lastname, email, password1, password2)
            userViewModel.registerUser(registerRequest)
        }
   }


    }








//    private fun validateForm(){
//        var firstname = binding.etFirstname.text.toString()
//        var lastname = binding.etLastname.text.toString()
//        var email = binding.etEmail1.text.toString()
//        var password1 = binding.etPassword1.text.toString()
//        var password2 = binding.etPassword2.text.toString()
//
//        var error = false
//        if(password1 == password2){
//            binding.btnSignup
//        }
//       else{
//           binding.tilPassword2.error="Invalid password"
//        }
//
//        if(firstname.isBlank()){
//            error = true
//           binding.tilFirstname.error = "firstname is required"
//        }
//
//        if(lastname.isBlank()){
//            error = true
//            binding.tilLastname.error = "lastname is required"
//        }
//
//        if(email.isBlank()){
//            error = true
//            binding.tilEmail1.error = "Email is required"
//        }
//
//        if(password1.isBlank()){
//            error = true
//            binding.tilPassword1.error = "Password is required"
//        }
//
//        if(password2.isBlank()){
//            error = true
//            binding.tilPassword2.error = "Password is required"
//        }
//
//        if(!error){
//            val registerRequest = RegisterRequest(firstname, lastname, email, password1, password2)
//            makeRegistrationRequest(registerRequest)
//        }
//    }
//