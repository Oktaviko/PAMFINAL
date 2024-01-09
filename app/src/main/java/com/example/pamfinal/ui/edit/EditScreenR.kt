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
import com.example.pamfinal.ui.add.EntryBodyP
import com.example.pamfinal.ui.add.EntryBodyR
import kotlinx.coroutines.launch

object EditDestinationRumahSakit : DestinasiNavigasi {
    override val route = "item_edit_rumahsakit"
    override val titleRes = "Edit RumahSakit"
    const val rumahsakitId = "itemId"
    val routeWithArgs = "${EditDestinationRumahSakit.route}/{$rumahsakitId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenRumahSakit(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModelRumahSakit = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            BPJSTopAppBar(
                title = EditDestinationRumahSakit.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ){innerPadding ->
        EntryBodyR(
            addUIState = viewModel.rumahsakitUiState,
            onCustomerValueChange = viewModel::updateUIState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateRumahSakit()
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