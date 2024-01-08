package com.example.pamfinal.ui

import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.model.RumahSakit


data class AddUIStatePendaftar(
    val addEventPendaftar: AddEventPendaftar = AddEventPendaftar(),
)
data class AddUIStateRS(
    val addEventRS: AddEventRS = AddEventRS(),
)

data class AddEventPendaftar(
    val nik: String = "",
    val nama: String = "",
    val alamat: String = "",
    val telepon: String = "",
    val tanggal_lahir: String = "",
)
data class AddEventRS(
    val id_rs: String = "",
    val nama_rs: String = "",
    val alamat_rs: String = "",
)

fun AddEventPendaftar.toPendaftar() = Pendaftar(
    nik=nik,
    nama= nama,
    alamat= alamat,
    telepon = telepon,
    tanggal_lahir = tanggal_lahir,

)
fun AddEventRS.toRS() = RumahSakit(
    id_rs =id_rs,
    nama_rs = nama_rs,
    alamat_rs = alamat_rs,
)
data class DetailUIStatePendaftar(
    val addEventPendaftar: AddEventPendaftar = AddEventPendaftar(),
)
data class DetailUIStateRS(
    val addEventRS: AddEventRS = AddEventRS(),
)
fun Pendaftar.toDetailPendaftar(): AddEventPendaftar =
    AddEventPendaftar(
        nik=nik,
        nama= nama,
        alamat= alamat,
        telepon = telepon,
        tanggal_lahir = tanggal_lahir,
    )
fun RumahSakit.toDetailRS(): AddEventRS =
    AddEventRS(
        id_rs =id_rs,
        nama_rs = nama_rs,
        alamat_rs = alamat_rs,
    )
fun Pendaftar.toUIStatePendaftar(): AddUIStatePendaftar = AddUIStatePendaftar(
    addEventPendaftar = this.toDetailPendaftar()
)
fun RumahSakit.toUIStateRS(): AddUIStateRS = AddUIStateRS(
    addEventRS = this.toDetailRS()
)

data class HomeUIStatePendaftar(
    val listPendaftar: List<Pendaftar> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateRS(
    val listPendaftar: List<Pendaftar> = listOf(),
    val dataLength: Int = 0
)