package com.example.pamfinal.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.ui.HomeUIStatePendaftar
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


sealed class PendaftarUIState {
    data class Success(val pendaftar: Flow<List<Pendaftar>>) : PendaftarUIState()
    object Error : PendaftarUIState()
    object Loading : PendaftarUIState()
}

class HomeViewModelPendaftar(private val pendaftarRepository: PendaftarRepository) : ViewModel(){

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIState: StateFlow<HomeUIStatePendaftar> = pendaftarRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIStatePendaftar(
                listPendaftar = it.toList(),
                it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStatePendaftar()
        )
}