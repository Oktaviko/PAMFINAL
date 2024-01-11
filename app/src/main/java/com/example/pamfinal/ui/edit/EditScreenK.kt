package com.example.pamfinal.ui.edit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.R
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.PenyediaViewModel
import com.example.pamfinal.ui.add.EntryBodyK
import com.example.pamfinal.ui.add.EntryBodyP
import com.example.pamfinal.ui.home.BodyHomeKartu
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Image(painter = painterResource(
                id = R.drawable.timorrrrrrrrr),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
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
}