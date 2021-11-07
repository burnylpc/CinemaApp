package com.example.cinema.features.movies_cards_screen.ui

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cinema.R
import com.example.cinema.base.loadImage

class MovieAboutActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_about_activity)

        val textAbout = findViewById<TextView>(R.id.textAbout)
        textAbout.text = intent.extras?.get("overview").toString()

        val movieImage = findViewById<ImageView>(R.id.movieImage)
        movieImage.loadImage(intent.extras?.get("httpPosterPath").toString())
    }

}