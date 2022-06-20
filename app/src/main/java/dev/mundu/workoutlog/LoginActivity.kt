package dev.mundu.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.mundu.workoutlog.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
 lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            validateForm()
            finish()
        }
        binding.tvSignup.setOnClickListener {
            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateForm(){
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
        var error=false

         if(email.isBlank()){
         binding.tilEmail.error = "Email is required"
             error = true
        }
        if(password.isBlank()){
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if(!error){
            startActivity(Intent(this,HomeActivity::class.java))

        }
    }
}