package com.example.cinema.features.movies_cards_screen.data.api

import com.example.cinema.features.movies_cards_screen.data.api.model.SourceModel
import retrofit2.http.GET

interface MovieCardApi {

    @GET("LukyanovAnatoliy/eca5141dedc79751b3d0b339649e06a3/raw/38f9419762adf27c34a3f052733b296385b6aa8d")
    suspend fun getMoviesCards() : SourceModel

}

//https://gist.githubusercontent.com/LukyanovAnatoliy/eca5141dedc79751b3d0b339649e06a3/raw/38f9419762adf27c34a3f052733b296385b6aa8d/
//const val BASE_URL = "https://gist.githubusercontent.com/"