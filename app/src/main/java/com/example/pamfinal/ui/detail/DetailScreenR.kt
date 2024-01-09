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
import com.example.pamfinal.model.RumahSakit
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.DetailUIStatePendaftar
import com.example.pamfinal.ui.DetailUIStateRS
import com.example.pamfinal.ui.PenyediaViewModel
import com.example.pamfinal.ui.toPendaftar
import com.example.pamfinal.ui.toRS
import kotlinx.coroutines.launch

object DetailDestinationRS : DestinasiNavigasi {
    override val route = "item_details_rs"
    override val titleRes = "Detail RS"
    const val id_rs = "itemId"
    val routeWithArgs = "$route/{$id_rs}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreenRS(
    navigateToEditItem: (String) -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModelRS = viewModel(factory = PenyediaViewModel.Factory)
){
    val uiState = viewModel.uiStateR.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            BPJSTopAppBar(
                title = DetailDestinationRS.titleRes,
                canNavigateBack = true,
                navigateUp = navigateBack
            )
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = { navigateToEditItem(uiState.value.addEventRS.id_rs) },
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
        ItemDetailsBodyR(
            detailUIState = uiState.value,
            onDelete = {
                coroutineScope.launch {
                    viewModel.deleteRS()
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
private fun ItemDetailsBodyR(
    detailUIState: DetailUIStateRS,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier.padding(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ){
        var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }

        ItemDetailsRS(
            rumahSakit = detailUIState.addEventRS.toRS(),
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
fun ItemDetailsRS(
    rumahSakit: RumahSakit,
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
                labelResID = "Nama Rumah Sakit",
                itemDetail = rumahSakit.nama_rs,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
            ItemDetailsRow(
                labelResID = "id Rumah Sakit",
                itemDetail = rumahSakit.id_rs,
                modifier = Modifier.padding(
                    horizontal = 15.dp
                )
            )
            ItemDetailsRow(
                labelResID = "Alamat Rumah Sakit",
                itemDetail = rumahSakit.alamat_rs,
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
        title = { Text("Are you sure?") },
        text = { Text("Delete") },
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
//