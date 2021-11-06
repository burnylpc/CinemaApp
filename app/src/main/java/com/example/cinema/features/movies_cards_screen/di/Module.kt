package com.example.cinema.features.movies_cards_screen.di

import com.example.cinema.features.movies_cards_screen.data.api.MovieCardApi
import com.example.cinema.features.movies_cards_screen.data.api.MovieRemoteSource
import com.example.cinema.features.movies_cards_screen.data.api.MovieRepository
import com.example.cinema.features.movies_cards_screen.data.api.MovieRepositoryImpl
import com.example.cinema.features.movies_cards_screen.domain.MovieInteractor
import com.example.cinema.features.movies_cards_screen.ui.MovieCardsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val moviesListScreenModule = module {

    single<MovieCardApi> {
        get<Retrofit>().create(MovieCardApi::class.java)
    }

    single<MovieRemoteSource> {
        MovieRemoteSource(get<MovieCardApi>())
    }

    single<MovieRepository> {
        MovieRepositoryImpl(get<MovieRemoteSource>())
    }

    single<MovieInteractor> {
        MovieInteractor(get<MovieRepository>())
    }

    viewModel {
        MovieCardsScreenViewModel(get<MovieInteractor>())
    }

}