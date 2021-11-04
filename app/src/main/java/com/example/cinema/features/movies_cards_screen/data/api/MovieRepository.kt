package com.example.cinema.features.movies_cards_screen.data.api

import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

interface MovieRepository {

    suspend fun getMoviesCards(): List<MovieCardDomainModel>

}