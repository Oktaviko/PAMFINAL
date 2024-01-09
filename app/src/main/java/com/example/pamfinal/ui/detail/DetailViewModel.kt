package com.example.pamfinal.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.data.RumahSakitRepository
import com.example.pamfinal.ui.DetailUIStatePendaftar
import com.example.pamfinal.ui.DetailUIStateRumahSakit
import com.example.pamfinal.ui.toDetailPendaftar
import com.example.pamfinal.ui.toDetailRumahSakit
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModelPendaftar (
    savedStateHandle: SavedStateHandle,
    private val repository: PendaftarRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILIS = 5_000L
    }

    val pendaftarId: String = checkNotNull(savedStateHandle[DetailDestinationPendaftar.pendaftarId])

    val uiStateP: StateFlow<DetailUIStatePendaftar> =
        repository.getPendaftarById(pendaftarId)
            .filterNotNull()
            .map {
                DetailUIStatePendaftar(addEventPendaftar = it.toDetailPendaftar())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILIS),
                initialValue = DetailUIStatePendaftar()
            )

    suspend fun deletePendaftar() {
        repository.delete(pendaftarId)
    }
}
class DetailViewModelRumahSakit (
    savedStateHandle: SavedStateHandle,
    private val repository: RumahSakitRepository
) : ViewModel() {
    companion object {
        private const val TIMEOUT_MILIS = 5_000L
    }

    val rumahsakitId: String = checkNotNull(savedStateHandle[DetailDestinationRumahSakit.rumahsakitId])

    val uiStateR: StateFlow<DetailUIStateRumahSakit> =
        repository.getRumahSakitById(rumahsakitId)
            .filterNotNull()
            .map {
                DetailUIStateRumahSakit(addEventRumahSakit = it.toDetailRumahSakit())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILIS),
                initialValue = DetailUIStateRumahSakit()
            )

    suspend fun deleteRumahSakit() {
        repository.delete(rumahsakitId)
    }
}


