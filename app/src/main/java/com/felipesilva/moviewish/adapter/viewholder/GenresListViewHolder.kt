package com.felipesilva.moviewish.adapter.viewholder

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.felipesilva.moviewish.R
import com.felipesilva.moviewish.data.model.Genre
import com.felipesilva.moviewish.view.fragment.HomeFragment
import kotlinx.android.synthetic.main.item_genre.view.*
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class GenresListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), KodeinAware {
    override val kodein: Kodein by closestKodein(itemView.context)
    private val homeFragment: HomeFragment by instance()
    val itemGenre = itemView.item_genre
    val genreTitle = itemView.text_genre_title

    fun bind(genre: Genre) {
        genreTitle.text = genre.name

        itemGenre.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("genre_id", genre.id.toString())
            bundle.putString("genre_name", genre.name)
            homeFragment.arguments = bundle
            (itemView.context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout_main, homeFragment).commit()
        }
    }
}