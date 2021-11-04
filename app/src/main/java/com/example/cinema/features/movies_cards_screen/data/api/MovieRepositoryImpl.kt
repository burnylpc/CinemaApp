package com.example.cinema.features.movies_cards_screen.data.api

import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

class MovieRepositoryImpl(private val source: MovieRemoteSource) : MovieRepository {

    override suspend fun getMoviesCards(): List<MovieCardDomainModel> {
        return source.getMoviesCards().results.map {
            it.toDomain()
        }
    }

}