package dev.mundu.workoutlog.ui

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.Observer
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.mundu.workoutlog.R
import dev.mundu.workoutlog.databinding.ActivityHomeBinding
import dev.mundu.workoutlog.models.LoginResponse
import dev.mundu.workoutlog.utils.Constants
import dev.mundu.workoutlog.viewmodel.ExerciseViewModel

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    lateinit var fcvHome: FragmentContainerView
    lateinit var bnvHome: BottomNavigationView
    val exerciseViewModel: ExerciseViewModel by viewModels()
    lateinit var sharedPrefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setBottomNav()
        sharedPrefs = getSharedPreferences(Constants.prefsFile, MODE_PRIVATE)
        val token = sharedPrefs.getString(Constants.accessToken, Constants.EMPTY_STRING)
        exerciseViewModel.fetchExerciseCategories(token!!)
        binding.tvLogOut.setOnClickListener {
            val editor = sharedPrefs.edit()
            editor.putString("ACCESS_TOKEN", "")
            editor.putString("USER_ID", "")
            editor.putString("PROFILE_ID", "")
            editor.apply()
            startActivity(Intent(this, LoginResponse::class.java))
        }
    }

    override fun OnResume() {
        super.onResume()
        exerciseViewModel.exerciseCategoryLiveData.observe(this, Observer { exerciseCategories ->
            Toast.makeText(this, "fetched ${exerciseCategories.size} categories", Toast.LENGTH_LONG)
                .show()
        })
        exerciseViewModel.errorLiveData.observe(this, Observer { errorMsg ->
            Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
        })
    }


    fun castViews() {
        binding.fcvHome
        binding.bnvHome
    }

    fun setBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.plan -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment())
                        .commit()
                    true
                }

                R.id.track -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment())
                        .commit()
                    true
                }

                R.id.profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }

                else -> false
            }
        }
    }

companion object {
    fun getIntent(context: Context): Intent {
        return Intent(context, HomeActivity::class.java)
    }
}

}