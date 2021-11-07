package com.example.cinema.features.movies_cards_screen.ui

import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.example.cinema.R

class MoviePlayerActivity: AppCompatActivity() {

    private var mediaController: MediaController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_player_activity)

        val httpVideo = intent.extras?.get("httpVideo").toString()

        val videoView = findViewById<VideoView>(R.id.videoView)

        mediaController = MediaController(this)
        mediaController?.setAnchorView(videoView)
        videoView.setMediaController(mediaController)
        videoView.setVideoPath(httpVideo)
        videoView.requestFocus()
        videoView.start()

    }

}