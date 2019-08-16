package com.felipesilva.moviewish

import android.app.Application
import com.felipesilva.moviewish.data.database.genres.GenresDatabase
import com.felipesilva.moviewish.data.database.genres.GenresDatabaseImpl
import com.felipesilva.moviewish.data.database.moviedetails.MovieDetailsDatabase
import com.felipesilva.moviewish.data.database.moviedetails.MovieDetailsDatabaseImpl
import com.felipesilva.moviewish.data.database.movies.MoviesDatabase
import com.felipesilva.moviewish.data.database.movies.MoviesDatabaseImpl
import com.felipesilva.moviewish.remote.config.RetrofitConfig
import com.felipesilva.moviewish.repository.genres.GenresRepository
import com.felipesilva.moviewish.repository.genres.GenresRepositoryImpl
import com.felipesilva.moviewish.repository.moviedetails.MovieDetailsRepository
import com.felipesilva.moviewish.repository.moviedetails.MovieDetailsRepositoryImpl
import com.felipesilva.moviewish.repository.movies.MoviesRepository
import com.felipesilva.moviewish.repository.movies.MoviesRepositoryImpl
import com.felipesilva.moviewish.view.fragment.GenresFragment
import com.felipesilva.moviewish.view.fragment.HomeFragment
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MovieWishApp : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind() from provider { RetrofitConfig(applicationContext) }

        bind() from provider { HomeFragment() }

        bind() from provider { GenresFragment() }

        bind<MoviesDatabase>() with singleton {
            MoviesDatabaseImpl(
                instance()
            )
        }

        bind<MoviesRepository>() with singleton {
            MoviesRepositoryImpl(
                instance()
            )
        }

        bind<MovieDetailsDatabase>() with singleton {
            MovieDetailsDatabaseImpl(
                instance()
            )
        }

        bind<MovieDetailsRepository>() with singleton {
            MovieDetailsRepositoryImpl(
                instance()
            )
        }

        bind<GenresDatabase>() with singleton {
            GenresDatabaseImpl(
                instance()
            )
        }

        bind<GenresRepository>() with singleton {
            GenresRepositoryImpl(
                instance()
            )
        }
    }
}