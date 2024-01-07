package com.example.pamfinal.ui.edit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.PenyediaViewModel

object EditDestination : DestinasiNavigasi{
    override val route = "item_edit_pendaftar"
    override val titleRes = "Edit Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "${EditDestination.route}/{$pendaftarId}"
}

@Composable
fun EditScreenPendaftar(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}