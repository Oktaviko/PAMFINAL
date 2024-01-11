package com.example.pamfinal.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfinal.data.KartuRepository
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.data.RumahSakitRepository
import com.example.pamfinal.model.Kartu
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.model.RumahSakit
import com.example.pamfinal.ui.HomeUIStateKartu
import com.example.pamfinal.ui.HomeUIStatePendaftar
import com.example.pamfinal.ui.HomeUIStateRumahSakit
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
    val homeUIStateP: StateFlow<HomeUIStatePendaftar> = pendaftarRepository.getAll()
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
sealed class RumahSakitUIState {
    data class Success(val rumahsakit: Flow<List<RumahSakit>>) : RumahSakitUIState()
    object Error : RumahSakitUIState()
    object Loading : RumahSakitUIState()
}

class HomeViewModelRumahSakit(private val rumahsakitRepository: RumahSakitRepository) : ViewModel(){

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIStateR: StateFlow<HomeUIStateRumahSakit> = rumahsakitRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIStateRumahSakit(
                listRumahSakit = it.toList(),
                it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStateRumahSakit()
        )
}

sealed class KartuUIState {
    data class Success(val kartu: Flow<List<Kartu>>) : KartuUIState()
    object Error : KartuUIState()
    object Loading : KartuUIState()
}

class HomeViewModelKartu(private val kartuRepository: KartuRepository) : ViewModel(){

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
    val homeUIStateK: StateFlow<HomeUIStateKartu> = kartuRepository.getAll()
        .filterNotNull()
        .map {
            HomeUIStateKartu(
                listKartu = it.toList(),
                it.size)
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = HomeUIStateKartu()
        )
}
