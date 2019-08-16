package com.felipesilva.moviewish.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.adapter.GenresListAdapter
import com.felipesilva.moviewish.data.model.Genre
import com.felipesilva.moviewish.utilities.showToastLongMessage
import com.felipesilva.moviewish.viewmodel.GenresViewModel
import kotlinx.android.synthetic.main.fragment_genres.*
import kotlinx.android.synthetic.main.fragment_genres.view.*

class GenresFragment : Fragment() {
    private lateinit var genresViewModel: GenresViewModel
    private val genresList = mutableListOf<Genre>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_genres, container, false)

        genresViewModel = ViewModelProviders.of(this).get(GenresViewModel::class.java)

        activity?.title = "Genres"

        view.recycler_view_genres.apply {
            layoutManager = LinearLayoutManager(this@GenresFragment.context)
            adapter = GenresListAdapter(genresList)
        }

        genresViewModel.getGenresList().observe(this, Observer { genres ->
            if (genres != null) {
                if (genresList.isNotEmpty())
                    genresList.clear()

                genresList.addAll(genres.genres)
                recycler_view_genres.adapter?.notifyDataSetChanged()
            } else {
                this.context?.showToastLongMessage("Connection error")
            }
        })

        return view
    }
}