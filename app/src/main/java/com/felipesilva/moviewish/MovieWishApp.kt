package com.felipesilva.moviewish

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

class MovieWishApp : Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {

    }
}