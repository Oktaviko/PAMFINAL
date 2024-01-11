package com.example.pamfinal.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pamfinal.BPJSApplication
import com.example.pamfinal.ui.add.AddViewModelKartu
import com.example.pamfinal.ui.add.AddViewModelPendaftar
import com.example.pamfinal.ui.add.AddViewModelRumahSakit
import com.example.pamfinal.ui.detail.DetailViewModelKartu

import com.example.pamfinal.ui.detail.DetailViewModelPendaftar
import com.example.pamfinal.ui.detail.DetailViewModelRumahSakit
import com.example.pamfinal.ui.edit.EditViewModelKartu

import com.example.pamfinal.ui.edit.EditViewModelPendaftar
import com.example.pamfinal.ui.edit.EditViewModelRumahSakit
import com.example.pamfinal.ui.home.HomeViewModelKartu
import com.example.pamfinal.ui.home.HomeViewModelPendaftar
import com.example.pamfinal.ui.home.HomeViewModelRumahSakit


fun CreationExtras.aplikasiBPJS(): BPJSApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as BPJSApplication)

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModelPendaftar(aplikasiBPJS().container.pendaftarRepository)
        }

        initializer {
            AddViewModelPendaftar(aplikasiBPJS().container.pendaftarRepository)
        }

        initializer {
            DetailViewModelPendaftar(
                createSavedStateHandle(),
                aplikasiBPJS().container.pendaftarRepository
            )
        }

        initializer {
            EditViewModelPendaftar(
                createSavedStateHandle(),
                aplikasiBPJS().container.pendaftarRepository
            )
        }

        initializer {
            HomeViewModelRumahSakit(aplikasiBPJS().container.rumahsakitRepository)
        }
        initializer {
            AddViewModelRumahSakit(aplikasiBPJS().container.rumahsakitRepository)
        }
        initializer {
            DetailViewModelRumahSakit(
                createSavedStateHandle(),
                aplikasiBPJS().container.rumahsakitRepository
            )
        }

        initializer {
            EditViewModelRumahSakit(
                createSavedStateHandle(),
                aplikasiBPJS().container.rumahsakitRepository
            )
        }

        initializer {
            HomeViewModelKartu(aplikasiBPJS().container.kartuRepository)
        }
        initializer {
            AddViewModelKartu(aplikasiBPJS().container.kartuRepository)
        }
        initializer {
            DetailViewModelKartu(
                createSavedStateHandle(),
                aplikasiBPJS().container.kartuRepository
            )
        }

        initializer {
            EditViewModelKartu(
                createSavedStateHandle(),
                aplikasiBPJS().container.kartuRepository
            )
        }
    }
}

