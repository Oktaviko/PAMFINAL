package com.example.pamfinal.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamfinal.BPJSApplication
import com.example.pamfinal.ui.add.AddViewModel
import com.example.pamfinal.ui.detail.DetailViewModel

fun CreationExtras.aplikasiBPJS(): BPJSApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BPJSApplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            AddViewModel(aplikasiBPJS().container.pendaftarRepository)
        }
        initializer {
            DetailViewModel(
                createSavedStateHandle(),
                aplikasiBPJS().container.pendaftarRepository
            )
        }
    }
}

