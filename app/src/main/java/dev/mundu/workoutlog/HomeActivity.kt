package dev.mundu.workoutlog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.mundu.workoutlog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
//    lateinit var fcvHome:FragmentContainerView
//    lateinit var bnvHome:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        castViews()
        setBottomNav()


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
}