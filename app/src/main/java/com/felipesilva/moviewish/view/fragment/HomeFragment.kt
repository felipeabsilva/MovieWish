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
import com.felipesilva.moviewish.utilities.SharedParameter
import com.felipesilva.moviewish.utilities.showToastLongMessage
import com.felipesilva.moviewish.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private val moviesList = mutableListOf<Movie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        handleProgressBarAndFrameLayoutVisibility(View.GONE, View.VISIBLE)

        handleMovieListCall()

        setMoviesRecyclerView(view)

        setMoviesObserver()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.top_toolbar_menu, menu)

        menu?.let {
            it.findItem(R.id.toolbar_most_popular_filter).isChecked = true
        }

        super.onCreateOptionsMenu(menu, inflater)
    }

    private fun handleProgressBarAndFrameLayoutVisibility(frameVisibility: Int, progressBarVisibility: Int) {
        activity?.frame_layout_main?.visibility = frameVisibility
        activity?.main_progress_bar?.visibility = progressBarVisibility
    }

    private fun handleMovieListCall() {
        val bundle = arguments
        if (bundle != null) {
            val genreId = bundle.getString(SharedParameter.GENRE_ID)
            val genreName = bundle.getString(SharedParameter.GENRE_NAME)
            if (genreId != null && genreName != null) {
                setHasOptionsMenu(false)
                activity?.title = genreName
                homeViewModel.makeCallMoviesByGenre(genreId)
            }
        } else {
            activity?.title = getString(R.string.most_popular)
            setHasOptionsMenu(true)
            homeViewModel.makeCallMoviesSortedByMostPopular()
        }
    }

    private fun setMoviesRecyclerView(view: View) {
        view.recycler_view_home.apply {
            layoutManager = LinearLayoutManager(this@HomeFragment.context)
            adapter = MoviesListAdapter(moviesList)
        }
    }

    private fun setMoviesObserver() {
        homeViewModel.getMovies().observe(this, Observer { movies ->
            if (movies != null) {
                if (moviesList.isNotEmpty())
                    moviesList.clear()

                moviesList.addAll(movies)
                handleProgressBarAndFrameLayoutVisibility(View.VISIBLE, View.GONE)
                recycler_view_home.adapter?.notifyDataSetChanged()
            } else {
                handleProgressBarAndFrameLayoutVisibility(View.GONE, View.GONE)
                this.context?.showToastLongMessage(getString(R.string.connection_error))
            }
        })
    }
}