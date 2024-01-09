package com.example.pamfinal.ui.detail

import com.example.pamfinal.navigation.DestinasiNavigasi

object DetailDestinationRumahSakit : DestinasiNavigasi {
    override val route = "item_details_rumahsakit"
    override val titleRes = "Detail Rumah Sakit"
    const val rumahsakitId = "itemId"
    val routeWithArgs = "$route/{$rumahsakitId}"
}
