package com.example.pamfinal.ui.edit

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.PenyediaViewModel
import com.example.pamfinal.ui.add.EntryBodyK
import com.example.pamfinal.ui.add.EntryBodyP
import kotlinx.coroutines.launch

object EditDestinationKartu : DestinasiNavigasi {
    override val route = "item_edit_kartu"
    override val titleRes = "Edit Kartu"
    const val kartuId = "itemkartuId"
    val routeWithArgs = "${EditDestinationKartu.route}/{$kartuId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenKartu(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModelKartu = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            BPJSTopAppBar(
                title = EditDestinationKartu.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ){innerPadding ->
        EntryBodyK(
            addUIState = viewModel.kartuUiState,
            onKartuValueChange = viewModel::updateUIState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateKartu()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
        )

    }
}