package dev.mundu.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {
    lateinit var tvHeading:TextView
    lateinit var tilEmail:TextInputLayout
    lateinit var tilPassword:TextInputLayout
    lateinit var etEmail:TextInputEditText
    lateinit var etPassword:TextInputEditText
    lateinit var btnLogin:Button
    lateinit var tvSignup:TextView
    lateinit var tvAccount:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        tvHeading = findViewById(R.id.tvHeading)
        tilEmail = findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        etPassword= findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvSignup = findViewById(R.id.tvSignup)
        tvAccount = findViewById(R.id.tvAccount)

//        btnLogin.setOnClickListener {
//            validateForm()
//        }
        btnLogin.setOnClickListener {
            validateForm()
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        tvSignup.setOnClickListener {
            val intent=Intent(this,SignupActivity::class.java)
            startActivity(intent)
        }

    }
    private fun validateForm(){
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()
        var error=false

         if(email.isBlank()){
         tilEmail.error = "Email is required"
             error = true
        }
        if(password.isBlank()){
            tilPassword.error = "Password is required"
            error = true
        }
        if(!error){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }

    }

}