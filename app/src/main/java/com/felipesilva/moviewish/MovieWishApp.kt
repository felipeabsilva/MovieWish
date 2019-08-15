package com.felipesilva.moviewish

import android.app.Application
import com.felipesilva.moviewish.data.database.MoviesDatabase
import com.felipesilva.moviewish.data.database.MoviesDatabaseImpl
import com.felipesilva.moviewish.remote.config.RetrofitConfig
import com.felipesilva.moviewish.repository.Repository
import com.felipesilva.moviewish.repository.RepositoryImpl
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MovieWishApp : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        bind() from provider { RetrofitConfig() }

        bind<MoviesDatabase>() with singleton { MoviesDatabaseImpl(instance()) }

        bind<Repository>() with singleton { RepositoryImpl(instance()) }
    }
}