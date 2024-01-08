package com.example.pamfinal.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.ui.AddEventPendaftar
import com.example.pamfinal.ui.AddUIStatePendaftar
import com.example.pamfinal.ui.toPendaftar
import com.example.pamfinal.ui.toUIStatePendaftar
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: PendaftarRepository
) : ViewModel(){

    var pendaftarUiState by mutableStateOf(AddUIStatePendaftar())
        private set

    private val pendaftarId: String = checkNotNull(savedStateHandle[EditDestination.pendaftarId])

    init{
        viewModelScope.launch {
            pendaftarUiState =
                repository.getPendaftarById(pendaftarId)
                    .filterNotNull()
                    .first()
                    .toUIStatePendaftar()
        }
    }

    fun updateUIState(addEvent: AddEventPendaftar){
        pendaftarUiState = pendaftarUiState.copy(addEventPendaftar = addEvent)
    }

    suspend fun updatePendaftar(){
        repository.update(pendaftarUiState.addEventPendaftar.toPendaftar())
    }
}