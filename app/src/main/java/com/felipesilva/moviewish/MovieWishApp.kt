package com.felipesilva.moviewish

import android.app.Application
import com.felipesilva.moviewish.data.database.*
import com.felipesilva.moviewish.remote.config.RetrofitConfig
import com.felipesilva.moviewish.repository.*
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

        bind<MoviesDatabase>() with singleton { MoviesDatabaseImpl(instance()) }

        bind<Repository>() with singleton { RepositoryImpl(instance()) }

        bind<MovieDetailsDatabase>() with singleton { MovieDetailsDatabaseImpl(instance()) }

        bind<MovieDetailsRepository>() with singleton { MovieDetailsRepositoryImpl(instance()) }

        bind<GenresDatabase>() with singleton { GenresDatabaseImpl(instance()) }

        bind<GenresRepository>() with singleton { GenresRepositoryImpl(instance()) }
    }
}