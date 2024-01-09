package com.example.pamfinal.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamfinal.BPJSApplication
import com.example.pamfinal.ui.add.AddViewModelPendaftar
import com.example.pamfinal.ui.add.AddViewModelRS
import com.example.pamfinal.ui.detail.DetailViewModelPendaftar
import com.example.pamfinal.ui.detail.DetailViewModelRS
import com.example.pamfinal.ui.edit.EditViewModel

fun CreationExtras.aplikasiBPJS(): BPJSApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BPJSApplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            AddViewModelPendaftar(aplikasiBPJS().container.pendaftarRepository)
        }
        initializer {
            AddViewModelRS(aplikasiBPJS().container.rsRepository)
        }
        initializer {
            DetailViewModelPendaftar(
                createSavedStateHandle(),
                aplikasiBPJS().container.pendaftarRepository
            )
        }
        initializer {
            DetailViewModelRS(
                createSavedStateHandle(),
                aplikasiBPJS().container.rsRepository
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                aplikasiBPJS().container.pendaftarRepository
            )
        }
    }
}

