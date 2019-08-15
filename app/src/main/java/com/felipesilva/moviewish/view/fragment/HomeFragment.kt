package com.felipesilva.moviewish.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.adapter.MoviesListAdapter
import com.felipesilva.moviewish.data.model.Movie
import com.felipesilva.moviewish.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private val moviesList = mutableListOf<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        homeViewModel.getMovies().observe(this, Observer { movies ->
            movies?.let {
                if (moviesList.isNotEmpty())
                    moviesList.clear()

                moviesList.addAll(it)
                recycler_view_home.adapter?.notifyDataSetChanged()
            }
        })

        view.recycler_view_home.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
            adapter = MoviesListAdapter(moviesList)
        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.top_toolbar_menu, menu)
    }
}