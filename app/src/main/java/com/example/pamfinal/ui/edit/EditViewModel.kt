package com.example.pamfinal.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pamfinal.data.KartuRepository
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.data.RumahSakitRepository
import com.example.pamfinal.ui.AddEventKartuBpjs
import com.example.pamfinal.ui.AddEventPendaftar
import com.example.pamfinal.ui.AddEventRumahSakit
import com.example.pamfinal.ui.AddUIStateKartuBpjs

import com.example.pamfinal.ui.AddUIStatePendaftar
import com.example.pamfinal.ui.AddUIStateRumahSakit
import com.example.pamfinal.ui.toKartuBpjs

import com.example.pamfinal.ui.toPendaftar
import com.example.pamfinal.ui.toRumahSakit
import com.example.pamfinal.ui.toUIStateKartuBpjs

import com.example.pamfinal.ui.toUIStatePendaftar
import com.example.pamfinal.ui.toUIStateRumahSakit
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModelPendaftar (
    savedStateHandle: SavedStateHandle,
    private val repository: PendaftarRepository
) : ViewModel(){

    var pendaftarUiState by mutableStateOf(AddUIStatePendaftar())
        private set

    private val pendaftarId: String = checkNotNull(savedStateHandle[EditDestinationPendaftar.pendaftarId])

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
class EditViewModelRumahSakit (
    savedStateHandle: SavedStateHandle,
    private val repository: RumahSakitRepository
) : ViewModel(){

    var rumahsakitUiState by mutableStateOf(AddUIStateRumahSakit())
        private set

    private val rumahsakitId: String = checkNotNull(savedStateHandle[EditDestinationRumahSakit.rumahsakitId])

    init{
        viewModelScope.launch {
            rumahsakitUiState =
                repository.getRumahSakitById(rumahsakitId)
                    .filterNotNull()
                    .first()
                    .toUIStateRumahSakit()
        }
    }

    fun updateUIState(addEvent: AddEventRumahSakit){
        rumahsakitUiState = rumahsakitUiState.copy(addEventRumahSakit = addEvent)
    }

    suspend fun updateRumahSakit(){
        repository.update(rumahsakitUiState.addEventRumahSakit.toRumahSakit())
    }
}
class EditViewModelKartu (
    savedStateHandle: SavedStateHandle,
    private val repository: KartuRepository
) : ViewModel(){

    var kartuUiState by mutableStateOf(AddUIStateKartuBpjs())
        private set

    private val kartuId: String = checkNotNull(savedStateHandle[EditDestinationKartu.kartuId])

    init{
        viewModelScope.launch {
            kartuUiState =
                repository.getKartuById(kartuId)
                    .filterNotNull()
                    .first()
                    .toUIStateKartuBpjs()
        }
    }

    fun updateUIState(addEvent: AddEventKartuBpjs){
        kartuUiState = kartuUiState.copy(addEventKartuBpjs = addEvent)
    }

    suspend fun updateKartu(){
        repository.update(kartuUiState.addEventKartuBpjs.toKartuBpjs())
    }
}


