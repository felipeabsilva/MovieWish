package com.felipesilva.moviewish.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.view.fragment.GenresFragment
import com.felipesilva.moviewish.view.fragment.HomeFragment
import com.felipesilva.moviewish.viewmodel.HomeViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeFragment: HomeFragment
    private lateinit var genresFragment: GenresFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view_main)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeFragment = HomeFragment()
        genresFragment = GenresFragment()

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        bringHomeFragment()
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                bringHomeFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                bringGenresFragment()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_toolbar_menu, menu)
        menu?.let {
            it.findItem(R.id.toolbar_most_popular_filter).isChecked = true
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.toolbar_most_popular_filter -> {
            homeViewModel.makeCallMoviesSortedByMostPopular()
            item.isChecked = true
            true
        }

        R.id.toolbar_top_rated_filter -> {
            homeViewModel.makeCallMoviesSortByTopRated()
            item.isChecked = true
            true
        }

        R.id.toolbar_upcoming_filter -> {
            homeViewModel.makeCallMoviesSortByUpcoming()
            item.isChecked = true
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun bringHomeFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, homeFragment).commit()
    }

    private fun bringGenresFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout_main, genresFragment).commit()
    }
}
