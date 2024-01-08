package com.example.pamfinal.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamfinal.BPJSApplication
import com.example.pamfinal.ui.add.AddViewModelPendaftar
import com.example.pamfinal.ui.detail.DetailViewModel
import com.example.pamfinal.ui.edit.EditViewModel

fun CreationExtras.aplikasiBPJS(): BPJSApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BPJSApplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            AddViewModelPendaftar(aplikasiBPJS().container.pendaftarRepository)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiBPJS().container.pendaftarRepository
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

