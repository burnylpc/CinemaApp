package com.example.cinema.features.movies_cards_screen.data.api

import com.example.cinema.features.movies_cards_screen.data.api.model.MovieCardModel
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

fun MovieCardModel.toDomain() = MovieCardDomainModel(

    isAdult = this.isAdult,
    genres = this.genres,
    id = this.id,
    originalLanguage = this.originalLanguage,
    originalTitle = this.originalTitle,
    overview = this.overview,
    releaseDate = this.releaseDate,
    httpPosterPath = this.httpPosterPath,
    popularity = this.popularity,
    title = this.title,
    httpVideo = this.httpVideo,
    voteAverage = this.voteAverage,
    voteCount = this.voteCount

)