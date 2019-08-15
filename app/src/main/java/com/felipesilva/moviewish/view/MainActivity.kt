package com.felipesilva.moviewish.view

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.view.fragment.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView
    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                startHomeFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view_main)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        startHomeFragment()
    }

    private fun startHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, HomeFragment()).commit()
    }
}
