package com.example.pamfinal.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.ui.AddEvent
import com.example.pamfinal.ui.AddUIState
import com.example.pamfinal.ui.toPendaftar

class AddViewModel(private val pendaftarRepository: PendaftarRepository) : ViewModel(){
    var addUIState by mutableStateOf(AddUIState())
        private set

    fun updateAddUIState(addEvent: AddEvent){
        addUIState = AddUIState(addEvent = addEvent)
    }

    suspend fun addPendaftar(){
        pendaftarRepository.save(addUIState.addEvent.toPendaftar())
    }
}