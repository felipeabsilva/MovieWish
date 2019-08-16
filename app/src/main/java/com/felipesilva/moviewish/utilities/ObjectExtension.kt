package com.felipesilva.moviewish.utilities

import android.content.Context
import android.net.ConnectivityManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

fun Date.getCurrentFormmatedDate() = SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Date())

fun Context.isConnectedToNetwork(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
    return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting() ?: false
}

fun ImageView.setImageWithGlide(path: String?) {
    path?.let {
        Glide.with(this.context)
            .load(path)
            .into(this)
    }
}