package com.felipesilva.moviewish.data.database

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.felipesilva.moviewish.data.model.Genres
import com.felipesilva.moviewish.remote.MovieAPI
import com.felipesilva.moviewish.remote.config.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenresDatabaseImpl(retrofitConfig: RetrofitConfig) : GenresDatabase {
    private val genres: MutableLiveData<Genres> = MutableLiveData()

    private val api = retrofitConfig
        .buildRetrofit()
        .create(MovieAPI::class.java)

    private val handleGenresCallback = object: Callback<Genres> {
        override fun onResponse(call: Call<Genres>, response: Response<Genres>) {
            response.body()?.let {
                loadGenresList(it)
            }
        }

        override fun onFailure(call: Call<Genres>, t: Throwable) {
            Log.d("GenresDatabase", "Error on getting genres")
        }

    }

    override fun makeCallGenresList() = api.makeCallGenreList().enqueue(handleGenresCallback)

    override fun loadGenresList(genresList: Genres) {
        genres.value = genresList
    }

    override fun getGenresList(): LiveData<Genres> = genres

}