package com.example.pamfinal.ui.edit

import com.example.pamfinal.navigation.DestinasiNavigasi

object EditDestination : DestinasiNavigasi{
    override val route = "item_edit_pendaftar"
    override val titleRes = "Edit Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "${EditDestination.route}/{$pendaftarId}"
}