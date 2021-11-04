package com.example.newsfeed.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cinema.base.Event
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE> : ViewModel() {

    val viewState: MutableLiveData<VIEW_STATE> by lazy { MutableLiveData(initialViewState()) }

    abstract fun initialViewState(): VIEW_STATE

    //берет событие, которое произошло и предыдущее состояние(которые было на экране) и возвращает опционально новое состояние,
    //в котором будет учтено предыдущее состояние и событие
    //ех: если пользователь нажал на кнопку или переключил слайдер, то придет событие, что слайдер = 1 --- и это поолучится новое состояние
    abstract suspend fun reduce(event: Event, previousState: VIEW_STATE): VIEW_STATE?

    //UI event - то событие, возбудил пользователь (нажал на кнопку)
    fun processUiEvent(event: Event) {
        updateState(event)
    }

    //событие, которое запускает программа, или цепочки вычислений
    protected fun processDataEvent(event: Event) {
        updateState(event)
    }

    //запуск reduce. Если ничего нету, то возвращает initial состояние
    private fun updateState(event: Event) = viewModelScope.launch {
        val newViewState = reduce(event, viewState.value ?: initialViewState())
        if (newViewState != null && newViewState != viewState.value) {
            viewState.value = newViewState
        }
    }
}