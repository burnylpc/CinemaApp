package com.example.cinema.features.movies_cards_screen.ui

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.example.cinema.R
import com.example.cinema.base.loadImage
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

class MovieCardsScreenAdapter(private var cards: List<MovieCardDomainModel>) : RecyclerView.Adapter<MovieCardsScreenAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_Image: ImageView
        val item_title: TextView
        val item_overview: TextView

        init {
            item_Image    = itemView.findViewById(R.id.item_image)
            item_title    = itemView.findViewById(R.id.item_title)
            item_overview = itemView.findViewById(R.id.item_overview)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardsScreenAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_cards_items, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieCardsScreenAdapter.ViewHolder, position: Int) {
        holder.item_title.text    = cards[position].title
        holder.item_overview.text = cards[position].overview
        holder.item_Image.loadImage(cards[position].httpPosterPath)
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun updateMovieCards(newCards: List<MovieCardDomainModel>) {
        cards = newCards
        notifyDataSetChanged()
    }

}