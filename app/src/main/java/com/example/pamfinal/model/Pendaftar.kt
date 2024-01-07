package com.example.pamfinal.model

data class Pendaftar(
    val nik: String,
    val nama: String,
    val alamat: String,
    val telepon: String,
    val tanggal_lahir: String
){
    constructor(): this("","","","","")
}
data class Rumah_Sakit(
    val id_rs: String,
    val nama_rs: String,
    val alamat_rs: String
){
    constructor(): this("","","")
}


