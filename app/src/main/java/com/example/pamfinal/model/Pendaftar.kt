package com.example.pamfinal.model

data class Pendaftar(
    val nik: String,
    val nama: String,
    val alamat: String,
    val telepon: String,
    val jenis_kelamin: String
){
    constructor(): this("","","","","")
}
