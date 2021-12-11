package com.example.cinema.features.movies_cards_screen.data.api.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GenresModel (

    @SerializedName("name")
    val genre: String

) : Parcelable

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