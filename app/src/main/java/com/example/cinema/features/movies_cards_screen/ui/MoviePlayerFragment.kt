package com.example.cinema.features.movies_cards_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.cinema.R
import com.example.cinema.base.loadImage
import com.example.cinema.databinding.MoviePlayerFragmentBinding
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.Util

class MoviePlayerFragment : Fragment() {

    companion object {
        private const val MOVIE_KEY = "movie"
        fun newInstance(movie: MovieCardDomainModel) = MoviePlayerFragment().apply {
            arguments = bundleOf(Pair(MOVIE_KEY, movie))
        }
    }

    private val movie: MovieCardDomainModel by lazy {
        requireArguments().getParcelable(MOVIE_KEY)!!
    }

    private var viewBinding: MoviePlayerFragmentBinding? = null
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition = 0L
    private lateinit var uri: String
    private var player: ExoPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.movie_player_fragment, container, false)
        viewBinding = MoviePlayerFragmentBinding.inflate(inflater, container, false)

        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        uri = movie.httpVideo

        initializePlayer()
    }

    private fun initializePlayer() {
        player = ExoPlayer.Builder(this.requireContext())
            .build()
            .also { exoPlayer ->
                viewBinding!!.videoView.player = exoPlayer
                exoPlayer.playWhenReady = playWhenReady
                exoPlayer.seekTo(currentWindow, playbackPosition)
                exoPlayer.prepare()

                val mediaItem = MediaItem.fromUri(uri)
                exoPlayer.setMediaItem(mediaItem)
            }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer()
        }
    }

    override fun onResume() {
        super.onResume()
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer()
        }
    }


    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer()
        }
    }

    private fun releasePlayer() {
        player?.run {
            playbackPosition = this.currentPosition
            currentWindow = this.getCurrentMediaItemIndex()
            playWhenReady = this.playWhenReady
            release()
        }
        player = null
    }

}