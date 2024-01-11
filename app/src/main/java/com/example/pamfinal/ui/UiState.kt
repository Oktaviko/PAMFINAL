package com.example.pamfinal.ui

import com.example.pamfinal.model.Kartu
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.model.RumahSakit


data class AddUIStatePendaftar(
    val addEventPendaftar: AddEventPendaftar = AddEventPendaftar(),
)
data class AddUIStateRumahSakit(
    val addEventRumahSakit: AddEventRumahSakit = AddEventRumahSakit(),
)
data class AddUIStateKartuBpjs(
    val addEventKartuBpjs: AddEventKartuBpjs = AddEventKartuBpjs(),
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
data class AddEventKartuBpjs(
    val id_kartu: String = "",
    val pendaftar: String = "",
    val rumahSakit: String = "",
    val masa_aktif: String = "",
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
fun AddEventKartuBpjs.toKartuBpjs() = Kartu(
    id_kartu =id_kartu,
    pendaftar = pendaftar,
    rumahSakit = rumahSakit,
    masa_Aktif = masa_aktif,
)

data class DetailUIStatePendaftar(
    val addEventPendaftar: AddEventPendaftar = AddEventPendaftar(),
)
data class DetailUIStateRumahSakit(
    val addEventRumahSakit: AddEventRumahSakit = AddEventRumahSakit(),
)
data class DetailUIStateKartuBpjs(
    val addEventKartuBpjs: AddEventKartuBpjs = AddEventKartuBpjs(),
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
fun Kartu.toDetailKartu(): AddEventKartuBpjs =
    AddEventKartuBpjs(
        id_kartu = id_kartu,
        pendaftar = pendaftar,
        rumahSakit = rumahSakit,
        masa_aktif = masa_Aktif,
    )
fun Pendaftar.toUIStatePendaftar(): AddUIStatePendaftar = AddUIStatePendaftar(
    addEventPendaftar = this.toDetailPendaftar()
)
fun RumahSakit.toUIStateRumahSakit(): AddUIStateRumahSakit = AddUIStateRumahSakit(
    addEventRumahSakit = this.toDetailRumahSakit()
)
fun Kartu.toUIStateKartuBpjs(): AddUIStateKartuBpjs = AddUIStateKartuBpjs(
    addEventKartuBpjs = this.toDetailKartu()
)

data class HomeUIStatePendaftar(
    val listPendaftar: List<Pendaftar> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateRumahSakit(
    val listRumahSakit: List<RumahSakit> = listOf(),
    val dataLength: Int = 0
)
data class HomeUIStateKartu(
    val listPendaftar: List<Kartu> = listOf(),
    val dataLength: Int = 0
)