package com.example.pamfinal.ui.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.ui.DetailUIStatePendaftar
import com.example.pamfinal.ui.toDetailPendaftar
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModelPendaftar (
    savedStateHandle: SavedStateHandle,
    private val repository: PendaftarRepository
) : ViewModel(){
    companion object{
        private const val TIMEOUT_MILIS = 5_000L
    }

    val pendaftarId: String = checkNotNull(savedStateHandle[DetailDestination.pendaftarId])

    val uiState: StateFlow<DetailUIStatePendaftar> =
        repository.getPendaftarById(pendaftarId)
            .filterNotNull()
            .map {
                DetailUIStatePendaftar(addEvent = it.toDetailPendaftar())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILIS),
                initialValue = DetailUIStatePendaftar()
            )

    suspend fun deletePendaftar(){
        repository.delete(pendaftarId)
    }

}