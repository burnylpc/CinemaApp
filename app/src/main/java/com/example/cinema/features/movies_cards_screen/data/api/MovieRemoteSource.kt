package com.example.cinema.features.movies_cards_screen.data.api

import com.example.cinema.features.movies_cards_screen.data.api.model.SourceModel

class MovieRemoteSource(private val api: MovieCardApi) {

    suspend fun getMoviesCards() : SourceModel = api.getMoviesCards()

}