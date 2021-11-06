package com.example.cinema.features.movies_cards_screen.ui

import com.example.cinema.base.Event
import com.example.cinema.features.movies_cards_screen.domain.MovieInteractor
import com.example.newsfeed.base.BaseViewModel
import com.example.newsfeed.features.main_screen.ui.DataEvent
import com.example.newsfeed.features.main_screen.ui.UIEvent
import com.example.newsfeed.features.main_screen.ui.ViewState

class MovieCardsScreenViewModel(private val interactor: MovieInteractor) : BaseViewModel<ViewState>() {// : BaseViewModel<ViewState>() {

    init {
        processDataEvent(DataEvent.OnLoadData)
    }

    override fun initialViewState() = ViewState(emptyList(), true)

    override suspend fun reduce(event: Event, previousState: ViewState): ViewState? {

        when (event) {
            is DataEvent.OnLoadData -> {
                interactor.getMoviesCards().fold(
                    onSuccess = { movies ->
                        processDataEvent(DataEvent.OnLoadMoviesSuccess(movies))
                    },
                    onError = {}
                )
            }
            is DataEvent.OnLoadMoviesSuccess -> {
                return previousState.copy(movies = event.movies, isLoading = false)
            }

            is UIEvent.OnButtonAboutClick -> {
                //**??
            }
        }

        return null

    }

}