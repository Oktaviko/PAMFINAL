package com.example.pamfinal.ui.edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.pamfinal.data.PendaftarRepository
import com.example.pamfinal.ui.AddUIState

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repository: PendaftarRepository
) : ViewModel(){

    var pendaftarUiState by mutableStateOf(AddUIState())
        private set


}