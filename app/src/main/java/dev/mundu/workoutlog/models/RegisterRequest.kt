package dev.mundu.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name") var first_name :String,
    @SerializedName("last_name") var last_name : String,
    @SerializedName("email") var email : String,
    @SerializedName("password") var password : String,
    @SerializedName("phone_number") var phone_number : String
)
