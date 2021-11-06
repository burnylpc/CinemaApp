package com.example.newsfeed.features.main_screen.ui

import com.example.cinema.base.Event
import com.example.cinema.features.movies_cards_screen.domain.model.MovieCardDomainModel

/* С помощью контракта мы заранее должны спроектировать все действия
пользователя относительно нашего экрана (UIEvent), а также все действия,
которые будут происходить без пользователя (DataEvent) */

data class ViewState(
    val movies: List<MovieCardDomainModel>,
    val isLoading: Boolean
)

sealed class UIEvent() : Event {

    data class OnButtonAboutClick(val card: MovieCardDomainModel) : UIEvent()

}

sealed class DataEvent() : Event {

    object OnLoadData: DataEvent()

    data class OnLoadMoviesSuccess(val movies: List<MovieCardDomainModel>) : DataEvent()

}

