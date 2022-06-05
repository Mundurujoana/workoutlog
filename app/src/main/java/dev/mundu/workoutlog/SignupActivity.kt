package dev.mundu.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignupActivity : AppCompatActivity() {
    lateinit var tvCreate:TextView
    lateinit var mvFirstname:ImageView
    lateinit var tilFirstname:TextInputLayout
    lateinit var etFirstname:TextInputEditText
    lateinit var mvLastname:ImageView
    lateinit var tilLastname:TextInputLayout
    lateinit var etLastname:TextInputEditText
    lateinit var mvEmail:ImageView
    lateinit var tilEmail1:TextInputLayout
    lateinit var etEmail1:TextInputEditText
    lateinit var mvPassword:ImageView
    lateinit var tilPassword1:TextInputLayout
    lateinit var etPassword1:TextInputEditText
    lateinit var mvPassword1:ImageView
    lateinit var tilPassword2:TextInputLayout
    lateinit var etPassword2:TextInputEditText
    lateinit var btnSignup:Button
    lateinit var tvAlready:TextView
    lateinit var tvLogin:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        tvCreate = findViewById(R.id.tvCreate)
        mvFirstname = findViewById(R.id.mvFirstname)
        tilFirstname = findViewById(R.id.tilFirstname)
        etFirstname = findViewById(R.id.etFirstname)
        mvLastname = findViewById(R.id.mvLastname)
        tilLastname = findViewById(R.id.tilLastname)
        etLastname = findViewById(R.id.etLastname)
        mvEmail = findViewById(R.id.mvEmail)
        tilEmail1 = findViewById(R.id.tilEmail1)
        etEmail1 = findViewById(R.id.etEmail1)
        mvPassword = findViewById(R.id.mvPassword)
        tilPassword1 = findViewById(R.id.tilPassword1)
        etPassword1 = findViewById(R.id.etPassword1)
        mvPassword1 = findViewById(R.id.mvPassword1)
        tilPassword2 = findViewById(R.id.tilPassword2)
        etPassword2 = findViewById(R.id.etPassword2)
        btnSignup = findViewById(R.id.btnSignup)
        tvAlready = findViewById(R.id.tvAlready)
        tvLogin = findViewById(R.id.tvLogin)


        btnSignup.setOnClickListener {
            validateForm()

        }


        tvLogin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }
    private fun validateForm(){
        var firstname = etFirstname.text.toString()
        var lastname = etLastname.text.toString()
        var email = etEmail1.text.toString()
        var password1 = etPassword1.text.toString()
        var password2 = etPassword2.text.toString()

        if(password1 == password2){
            btnSignup
        }
       else{
           tilPassword2.error="Invalid password"
        }

        if(firstname.isBlank()){
            tilFirstname.error = "firstname is required"
        }

        if(lastname.isBlank()){
            tilLastname.error = "lastname is required"
        }

        if(email.isBlank()){
            tilEmail1.error = "Email is required"
        }

        if(password1.isBlank()){
            tilPassword1.error = "Password is required"
        }

        if(password2.isBlank()){
            tilPassword2.error = "Password is required"
        }

    }


}