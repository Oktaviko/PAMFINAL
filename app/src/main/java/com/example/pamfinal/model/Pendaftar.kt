package com.example.pamfinal.model

data class Pendaftar(
    val nik: String,
    val nama: String,
    val alamat: String,
    val tanggal_lahir: String,
    val telepon: String,
){
    constructor(): this("","","","","")
}
data class RumahSakit(
    val id_rs: String,
    val nama_rs: String,
    val alamat_rs: String,
){
    constructor(): this("","","")
}

data class Kartu(
    val id_kartu: String,
    val Pendaftar: Pendaftar,
    val RumahSakit: RumahSakit,
    val masa_Aktif: String,
){
    constructor(): this("",Pendaftar(),RumahSakit(),"")
}


