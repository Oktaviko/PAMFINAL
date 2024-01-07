package com.example.pamfinal

import com.example.pamfinal.model.Pendaftar


data class AddUIState(
    val addEvent: AddEvent = AddEvent(),
)

data class AddEvent(
    val nik: String = "",
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = "",
    val tanggal_lahir: String = "",
)

fun AddEvent.toPendaftar() = Pendaftar(
    nik=nik,
    nama= nama,
    alamat= alamat,
    telepon = telepon,
    tanggal_lahir = tanggal_lahir,

)

data class DetailUIState(
    val addEvent: AddEvent = AddEvent(),
)

fun Pendaftar.toDetailPendaftar(): AddEvent =
    AddEvent(
        nik=nik,
        nama= nama,
        alamat= alamat,
        telepon = telepon,
        tanggal_lahir = tanggal_lahir,
    )

fun Pendaftar.toUIStatePendaftar(): AddUIState = AddUIState(
    addEvent = this.toDetailPendaftar()
)

data class HomeUIState(
    val listPendaftar: List<Pendaftar> = listOf(),
    val dataLength: Int = 0
)