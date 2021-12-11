package com.example.cinema.features.movies_cards_screen.domain.model

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import com.example.cinema.features.movies_cards_screen.data.api.model.GenresModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieCardDomainModel(

    val isAdult: Boolean,
    val genres: List<GenresModel>,
    val id: Int,
    val originalLanguage: String,
    val originalTitle: String,
    val overview: String,
    val releaseDate: String,
    val httpPosterPath: String,
    val popularity: Double,
    val title: String,
    val httpVideo: String,
    val voteAverage: Double,
    val voteCount: Int

) : Parcelable