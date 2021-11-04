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

//https://gist.githubusercontent.com/LukyanovAnatoliy/eca5141dedc79751b3d0b339649e06a3/raw/38f9419762adf27c34a3f052733b296385b6aa8d/
const val BASE_URL = "https://gist.githubusercontent.com/"
val moviesListScreenModule = module {

//    single {
//        OkHttpClient.Builder()
//            .build()
//    }
//
//    single {
//        Retrofit.Builder()
//            .addConverterFactory(GsonConverterFactory.create())
//            .baseUrl(BASE_URL)
//            .client(get())
//            .build()
//    }

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