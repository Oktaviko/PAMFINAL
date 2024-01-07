package com.example.pamfinal.ui.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pamfinal.navigation.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details_pendaftar"
    override val titleRes = "Detail Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "$route/{$pendaftarId}"
}
@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit,
    modifier: Modifier = Modifier
){

}