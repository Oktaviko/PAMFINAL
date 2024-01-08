package com.example.pamfinal.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.data.RumahSakitRepository
import com.example.pamfinal.ui.AddEventPendaftar
import com.example.pamfinal.ui.AddEventRS
import com.example.pamfinal.ui.AddUIStatePendaftar
import com.example.pamfinal.ui.AddUIStateRS
import com.example.pamfinal.ui.toPendaftar
import com.example.pamfinal.ui.toRS

class AddViewModelPendaftar(private val pendaftarRepository: PendaftarRepository) : ViewModel(){
    var addUIStatePendftar by mutableStateOf(AddUIStatePendaftar())
        private set

    fun updateAddUIState(addEvent: AddEventPendaftar){
        addUIStatePendftar = AddUIStatePendaftar(addEvent = addEvent)
    }

    suspend fun addPendaftar(){
        pendaftarRepository.save(addUIStatePendftar.addEvent.toPendaftar())
    }
}
class AddViewModelRS(private val rumahSakitrepository: RumahSakitRepository) : ViewModel(){

    var addUIStateRS by mutableStateOf(AddUIStateRS())
        private set

    fun updateAddUIState(addEvent: AddEventRS){
        addUIStateRS = AddUIStateRS(addEvent = addEvent)
    }

    suspend fun addRS(){
        rumahSakitrepository.save(addUIStateRS.addEvent.toRS())
    }
}