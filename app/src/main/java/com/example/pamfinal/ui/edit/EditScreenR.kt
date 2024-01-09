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

object EditDestinationRS : DestinasiNavigasi{
    override val route = "item_edit_rs"
    override val titleRes = "Edit Rumah Sakit"
    const val rs_Id = "itemId"
    val routeWithArgs = "${EditDestinationRS.route}/{$rs_Id}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreenRS(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModelRumahSakit = viewModel(factory = PenyediaViewModel.Factory)
){
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            BPJSTopAppBar(
                title = EditDestinationRS.titleRes,
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ){innerPadding ->
        EntryBodyR(
            addUIState = viewModel.rsUiState,
            onRSValueChange = viewModel::updateUIState,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateRS()
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