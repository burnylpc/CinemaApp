package com.example.cinema.features.movies_cards_screen.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import com.example.cinema.R
import com.example.cinema.base.loadImage
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

class MovieAboutFragment : Fragment() {

    companion object {
        private const val MOVIE_KEY = "movie"
        fun newInstance(movie: MovieCardDomainModel) = MovieAboutFragment().apply {
            arguments = bundleOf(Pair(MOVIE_KEY, movie))
        }
    }

    private val movie: MovieCardDomainModel by lazy {
        requireArguments().getParcelable(MOVIE_KEY)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.movie_about_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textAbout = view.findViewById<TextView>(R.id.textAbout)
        textAbout.text = movie.overview

        val movieImage = view.findViewById<ImageView>(R.id.movieImage)
        movieImage.loadImage(movie.httpPosterPath)

        val textGenres = view.findViewById<TextView>(R.id.textGenres)
        textGenres.text = movie.genres.map { it.genre }.joinToString(separator = ", ")

        val textReleaseDate = view.findViewById<TextView>(R.id.textReleaseDate)
        textReleaseDate.text = movie.releaseDate.dropLast(movie.releaseDate.length - 4)

        val textTitle = view.findViewById<TextView>(R.id.textTitle)
        textTitle.text = movie.title

    }

}