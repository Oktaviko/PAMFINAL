package com.example.pamfinal.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
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


class AddViewModelPendaftar(private val pendaftarRepository: PendaftarRepository) : ViewModel(){
    var addUIStatePendftar by mutableStateOf(AddUIStatePendaftar())
        private set

    fun updateAddUIState(addEvent: AddEventPendaftar){
        addUIStatePendftar = AddUIStatePendaftar(addEventPendaftar = addEvent)
    }

    suspend fun addPendaftar(){
        pendaftarRepository.save(addUIStatePendftar.addEventPendaftar.toPendaftar())
    }
}
class AddViewModelRumahSakit(private val rumahsakitRepository: RumahSakitRepository) : ViewModel(){
    var addUIStateRumahSakit by mutableStateOf(AddUIStateRumahSakit())
        private set

    fun updateAddUIState(addEvent: AddEventRumahSakit){
        addUIStateRumahSakit = AddUIStateRumahSakit(addEventRumahSakit = addEvent)
    }

    suspend fun addRumahSakit(){
        rumahsakitRepository.save(addUIStateRumahSakit.addEventRumahSakit.toRumahSakit())
    }
}
class AddViewModelKartu(private val kartuRepository: KartuRepository) : ViewModel(){
    var addUIStateKartu by mutableStateOf(AddUIStateKartuBpjs())
        private set

    fun updateAddUIState(addEvent: AddEventKartuBpjs){
        addUIStateKartu = AddUIStateKartuBpjs(addEventKartuBpjs = addEvent)
    }

    suspend fun addKartu(){
        kartuRepository.save(addUIStateKartu.addEventKartuBpjs.toKartuBpjs())
    }
}
