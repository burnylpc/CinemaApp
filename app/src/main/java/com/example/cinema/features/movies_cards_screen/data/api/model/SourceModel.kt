package com.example.cinema.features.movies_cards_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class SourceModel(

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<MovieCardModel>,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("total_results")
    val totalResults: Int

)

/*{
    "page": 1,
    "results": [
    ..........
    ],
    "total_pages": 1,
    "total_results": 3
}*/