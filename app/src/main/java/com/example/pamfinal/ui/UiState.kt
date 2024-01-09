package com.example.pamfinal.ui

import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.model.RumahSakit


data class AddUIStatePendaftar(
    val addEventPendaftar: AddEventPendaftar = AddEventPendaftar(),
)
data class AddUIStateRumahSakit(
    val addEventRumahSakit: AddEventRumahSakit = AddEventRumahSakit(),
)

data class AddEventPendaftar(
    val nik: String = "",
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = "",
    val tanggal_lahir: String = "",
)
data class AddEventRumahSakit(
    val id_rs: String = "",
    val nama_rs: String = "",
    val alamat_rs: String = "",
)

fun AddEventPendaftar.toPendaftar() = Pendaftar(
    nik=nik,
    nama= nama,
    alamat= alamat,
    tanggal_lahir = tanggal_lahir,
    telepon = telepon,
)
fun AddEventRumahSakit.toRumahSakit() = RumahSakit(
    id_rs =id_rs,
    nama_rs = nama_rs,
    alamat_rs = alamat_rs,
)
data class DetailUIStatePendaftar(
    val addEventPendaftar: AddEventPendaftar = AddEventPendaftar(),
)
data class DetailUIStateRumahSakit(
    val addEventRumahSakit: AddEventRumahSakit = AddEventRumahSakit(),
)
fun Pendaftar.toDetailPendaftar(): AddEventPendaftar =
    AddEventPendaftar(
        nik=nik,
        nama= nama,
        alamat= alamat,
        telepon = telepon,
        tanggal_lahir = tanggal_lahir,
    )
fun RumahSakit.toDetailRumahSakit(): AddEventRumahSakit =
    AddEventRumahSakit(
        id_rs =id_rs,
        nama_rs = nama_rs,
        alamat_rs = alamat_rs,
    )
fun Pendaftar.toUIStatePendaftar(): AddUIStatePendaftar = AddUIStatePendaftar(
    addEventPendaftar = this.toDetailPendaftar()
)
fun RumahSakit.toUIStateRumahSakit(): AddUIStateRumahSakit = AddUIStateRumahSakit(
    addEventRumahSakit = this.toDetailRumahSakit()
)

data class HomeUIStatePendaftar(
    val listPendaftar: List<Pendaftar> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateRumahSakit(
    val listRumahSakit: List<RumahSakit> = listOf(),
    val dataLength: Int = 0
)