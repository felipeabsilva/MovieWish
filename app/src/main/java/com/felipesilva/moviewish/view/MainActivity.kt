package com.felipesilva.moviewish.view

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.view.fragment.GenresFragment
import com.felipesilva.moviewish.view.fragment.HomeFragment
import com.felipesilva.moviewish.viewmodel.HomeViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {
    override val kodein: Kodein by closestKodein()
    private lateinit var homeViewModel: HomeViewModel
    private val homeFragment: HomeFragment by instance()
    private val genresFragment: GenresFragment by instance()
    private lateinit var navView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navView = nav_view_main

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.toolbar_most_popular_filter -> {
            homeViewModel.makeCallMoviesSortedByMostPopular()
            handleOnMenuItemSelected(item)
            true
        }

        R.id.toolbar_top_rated_filter -> {
            homeViewModel.makeCallMoviesSortByTopRated()
            handleOnMenuItemSelected(item)
            true
        }

        R.id.toolbar_upcoming_filter -> {
            homeViewModel.makeCallMoviesSortByUpcoming()
            handleOnMenuItemSelected(item)
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

    private fun handleOnMenuItemSelected(item: MenuItem) {
        item.isChecked = true
        title = item.title
        frame_layout_main.visibility = View.GONE
        main_progress_bar.visibility = View.VISIBLE
    }
}
