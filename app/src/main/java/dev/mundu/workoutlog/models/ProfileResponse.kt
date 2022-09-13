package dev.mundu.workoutlog.models

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("gender") var green:String,
    @SerializedName("date_of_birth") var dateOfBirth:String,
    @SerializedName("weight") var weight:String,
    @SerializedName("height") var height:String,

    )
