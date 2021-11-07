package com.example.cinema.features.movies_cards_screen.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.base.loadImage
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

class MovieCardsScreenAdapter(private var cards: List<MovieCardDomainModel>) : RecyclerView.Adapter<MovieCardsScreenAdapter.ViewHolder>() {

    //private lateinit var context : Context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_Image: ImageView
        val item_title: TextView
        val item_genres: TextView
        val item_vote_average: TextView

        val buttonAbout: Button
        val buttonWatch: Button


        init {
            item_Image         = itemView.findViewById(R.id.item_image)
            item_title         = itemView.findViewById(R.id.item_title)
            item_genres        = itemView.findViewById(R.id.item_genres)
            item_vote_average  = itemView.findViewById(R.id.item_vote_average)

            buttonAbout = itemView.findViewById(R.id.buttonAbout)
            buttonWatch = itemView.findViewById(R.id.buttonWatch)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCardsScreenAdapter.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_cards_items, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieCardsScreenAdapter.ViewHolder, position: Int) {

        val card = cards[position]

        holder.item_Image.loadImage(card.httpPosterPath)
        holder.item_title.text = card.title
        holder.item_genres.text = card.genres.map { it.genre }.joinToString(separator = ", ")
        holder.item_vote_average.text = card.voteAverage.toString() + " / " + card.voteCount.toString()


        holder.buttonAbout.setOnClickListener {

            val intent = Intent(holder.itemView.context, MovieAboutActivity::class.java)
            intent.putExtra("overview", card.overview)
            intent.putExtra("httpPosterPath", card.httpPosterPath)
            startActivity(holder.itemView.context, intent, null)
        }


        holder.buttonWatch.setOnClickListener {

            val intent = Intent(holder.itemView.context, MoviePlayerActivity::class.java)
            startActivity(holder.itemView.context, intent, null)

        }
    }

    override fun getItemCount(): Int {
        return cards.size
    }

    fun updateMovieCards(newCards: List<MovieCardDomainModel>) {
        cards = newCards
        notifyDataSetChanged()
    }

}