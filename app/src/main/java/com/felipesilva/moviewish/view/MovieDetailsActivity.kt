package com.felipesilva.moviewish.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.data.model.MovieDetails
import com.felipesilva.moviewish.utilities.API
import com.felipesilva.moviewish.utilities.SharedParameter
import com.felipesilva.moviewish.utilities.setImageWithGlide
import com.felipesilva.moviewish.utilities.showToastLongMessage
import com.felipesilva.moviewish.viewmodel.MovieDetailsViewModel
import kotlinx.android.synthetic.main.activity_movie_detail.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        handleMovieDetailsLayoutVisibility(View.GONE)

        movieDetailsViewModel = ViewModelProviders.of(this).get(MovieDetailsViewModel::class.java)

        val movieId = intent.getIntExtra(SharedParameter.MOVIE_ID, 0)

        movieDetailsViewModel.makeCallMovieDetails(movieId)

        setMovieDetailsObserver()
    }

    private fun handleMovieDetailsLayoutVisibility(layoutVisibility: Int) {
        constraint_layout_movie_details.visibility = layoutVisibility
    }

    private fun bindData(movieDetails: MovieDetails) {
        image_movie_poster.setImageWithGlide("${API.IMAGE_DETAIL_POSTER_URL}${movieDetails.posterPath}")
        text_movie_overview.text = movieDetails.overview
        text_movie_title.text = movieDetails.title
        text_movie_release_date.text = SimpleDateFormat("MMMM dd, yyyy", Locale.US).format(movieDetails.releaseDate)
        text_movie_genres.text = movieDetailsViewModel.formatGenres(movieDetails.genres)
        text_production_companies.text = movieDetailsViewModel.formatProductionCompanies(movieDetails.productionCompanies)
        text_vote_average.text = "${getString(R.string.score)}: ${movieDetails.voteAverage}"
        text_movie_budget.text = "${getString(R.string.budget)}: ${NumberFormat.getCurrencyInstance(Locale.US).format(movieDetails.budget)}"
        text_movie_revenue.text = "${getString(R.string.revenue)}: ${NumberFormat.getCurrencyInstance(Locale.US).format(movieDetails.revenue)}"
    }

    private fun setMovieDetailsObserver() {
        movieDetailsViewModel.getMovieDetails().observe(this, Observer { movieDetails ->
            if (movieDetails != null) {
                movieDetails?.let {
                    handleMovieDetailsLayoutVisibility(View.VISIBLE)
                    bindData(it)
                }
            } else {
                handleMovieDetailsLayoutVisibility(View.GONE)
                this.showToastLongMessage(getString(R.string.connection_error))
            }
        })
    }
}