package dev.mundu.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.mundu.workoutlog.databinding.ActivityLoginBinding
import dev.mundu.workoutlog.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    lateinit var binding:ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validateForm()

        }


        binding.tvLogin.setOnClickListener {
            val intent= Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

    }
    private fun validateForm(){
        var firstname = binding.etFirstname.text.toString()
        var lastname = binding.etLastname.text.toString()
        var email = binding.etEmail1.text.toString()
        var password1 = binding.etPassword1.text.toString()
        var password2 = binding.etPassword2.text.toString()

        if(password1 == password2){
            binding.btnSignup
        }
       else{
           binding.tilPassword2.error="Invalid password"
        }

        if(firstname.isBlank()){
           binding.tilFirstname.error = "firstname is required"
        }

        if(lastname.isBlank()){
            binding.tilLastname.error = "lastname is required"
        }

        if(email.isBlank()){
            binding.tilEmail1.error = "Email is required"
        }

        if(password1.isBlank()){
            binding.tilPassword1.error = "Password is required"
        }

        if(password2.isBlank()){
            binding.tilPassword2.error = "Password is required"
        }

    }


}