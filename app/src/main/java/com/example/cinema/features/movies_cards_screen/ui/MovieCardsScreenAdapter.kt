package com.example.cinema.features.movies_cards_screen.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinema.R
import com.example.cinema.base.loadImage
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

class MovieCardsScreenAdapter(
    private var cards: List<MovieCardDomainModel>,
    private val onButtonAboutClick: (currentCard: MovieCardDomainModel) -> Unit,
    private val onButtonWatchClick: (currentCard: MovieCardDomainModel) -> Unit
) : RecyclerView.Adapter<MovieCardsScreenAdapter.ViewHolder>() {

//Адаптер делегат --?
//    private val yourAdapter = ListDelegationAdapter(
//        yourItemDelegate(::onClicked)
//    )
//
//    fun yourItemDelegate(onClicked: () -> Unit): AdapterDelegate<List<Item>> {
//        return adapterDelegateViewBinding<YourItem, Item, YourItemBinding>(
//            { layoutInflater, root -> YourItemBinding.inflate(layoutInflater, root, false) }) {
//
//            binding.root.setThrottledClickListener { onClicked() }
//
//            bind {
//                binding.tvTitle.text = item.title
//            }
//        }
//    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_Image = itemView.findViewById<ImageView>(R.id.item_image)
        val item_title = itemView.findViewById<TextView>(R.id.item_title)
        val item_genres = itemView.findViewById<TextView>(R.id.item_genres)
        val item_vote_average = itemView.findViewById<TextView>(R.id.item_vote_average)
        val item_releaseDate = itemView.findViewById<TextView>(R.id.item_releaseDate)

        val buttonAbout = itemView.findViewById<Button>(R.id.buttonAbout)
        val buttonWatch = itemView.findViewById<Button>(R.id.buttonWatch)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieCardsScreenAdapter.ViewHolder {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_cards_items, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: MovieCardsScreenAdapter.ViewHolder, position: Int) {

        val card = cards[position]

        holder.item_Image.loadImage(card.httpPosterPath)
        holder.item_title.text = card.title
        holder.item_genres.text = card.genres.map { it.genre }.joinToString(separator = ", ")
        holder.item_releaseDate.text = card.releaseDate.dropLast(card.releaseDate.length - 4)
        holder.item_vote_average.text =
            card.voteAverage.toString() + " / " + card.voteCount.toString()

        holder.buttonAbout.setOnClickListener {
            onButtonAboutClick(card)
        }

        holder.buttonWatch.setOnClickListener {
            onButtonWatchClick(card)
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