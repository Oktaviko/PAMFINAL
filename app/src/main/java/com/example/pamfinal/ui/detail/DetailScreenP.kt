package com.example.pamfinal.ui.detail

import com.example.pamfinal.navigation.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details_pendaftar"
    override val titleRes = "Detail Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "$route/{$pendaftarId}"
}
