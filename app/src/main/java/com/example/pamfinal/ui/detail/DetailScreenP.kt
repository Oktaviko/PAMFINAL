package com.example.pamfinal.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.DetailUIStatePendaftar
import com.example.pamfinal.ui.PenyediaViewModel
import com.example.pamfinal.ui.toPendaftar
import kotlinx.coroutines.launch

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details_pendaftar"
    override val titleRes = "Detail Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "$route/{$pendaftarId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenPendaftar(
    navigateToEditItem: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModelPendaftar = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            BPJSTopAppBar(
                title = DetailDestination.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItem(uiState.value.addEvent.nik) },
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "",
                )
            }
        }, modifier = modifier
    ){innerPadding ->
        ItemDetailsBody(
            detailUIState = uiState.value,
            onDelete = {
                coroutineScope.launch {
                    viewModel.deletePendaftar()
                    navigateBack()
                }
            },
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        )

    }
}
@Composable
private fun ItemDetailsBody(
    detailUIState: DetailUIStatePendaftar,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }

        ItemDetailsPendaftar(
            pendaftar = detailUIState.addEvent.toPendaftar(),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedButton(
            onClick = {deleteConfirmationRequired = true},
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Delete")
        }
        if (deleteConfirmationRequired){
            DeleteConfirmationDialog(
                onDeleteConfirm = {
                    deleteConfirmationRequired = false
                    onDelete()
                },
                onDeleteCancel = {
                    deleteConfirmationRequired = false },
                    modifier = Modifier.padding(12.dp)
                )
        }

    }
}
@Composable
fun ItemDetailsPendaftar(
    pendaftar: Pendaftar,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            ItemDetailsRow(
                labelResID = "Nama",
                itemDetail = pendaftar.nama,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
            ItemDetailsRow(
                labelResID = "NIK",
                itemDetail = pendaftar.nik,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
            ItemDetailsRow(
                labelResID = "Alamat",
                itemDetail = pendaftar.alamat,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
            ItemDetailsRow(
                labelResID = "TTL",
                itemDetail = pendaftar.tanggal_lahir,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
            ItemDetailsRow(
                labelResID = "No Telepon",
                itemDetail = pendaftar.telepon,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
        }
    }
}
@Composable
private fun ItemDetailsRow(
    labelResID: String,
    itemDetail: String,
    modifier: Modifier = Modifier
){
    Row(modifier = modifier){
        Text(text = labelResID,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetail,
            fontWeight = FontWeight.Bold)
    }
}
@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit,
    modifier: Modifier = Modifier
){
    AlertDialog(
        onDismissRequest = { /*TODO*/ },
        title = { Text("Are you sure?")},
        text = { Text("Delete")},
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "No")
            }
        },
        confirmButton = { 
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Yes")
            }
        }
    )
}