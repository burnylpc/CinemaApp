package com.example.cinema.features.movies_cards_screen.domain

import com.example.cinema.base.attempt
import com.example.cinema.features.movies_cards_screen.data.api.MovieRepository

class MovieInteractor(private val repository: MovieRepository) {

    suspend fun getMoviesCards() = attempt { repository.getMoviesCards() }

}