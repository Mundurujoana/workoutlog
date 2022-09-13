package dev.mundu.workoutlog.models

import com.google.gson.annotations.SerializedName

data class ExerciseCategory(
    //here de are telling refrofit to deserialise this objects
    @SerializedName("category-id") var categoryId: String,
    @SerializedName("category_name") var categoryName: String
)
