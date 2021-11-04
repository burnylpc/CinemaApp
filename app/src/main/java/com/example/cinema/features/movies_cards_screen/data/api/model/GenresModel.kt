package com.example.cinema.features.movies_cards_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class GenresModel (

    @SerializedName("name")
    val genre: String

)

/*"genres": [
{
    "name": "Romance"
},
{
    "name": "Comedy"
},
{
    "name": "Animation"
},
{
    "name": "Drama"
},
{
    "name": "Family"
}
]*/