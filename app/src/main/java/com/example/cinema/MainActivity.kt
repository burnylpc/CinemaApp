package com.example.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cinema.features.movies_cards_screen.ui.MovieCardsScreenFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.root, MovieCardsScreenFragment()).commit()

    }

}