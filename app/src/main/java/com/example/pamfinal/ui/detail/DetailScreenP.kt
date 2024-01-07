package com.example.pamfinal.ui.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.DetailUIState

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details_pendaftar"
    override val titleRes = "Detail Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "$route/{$pendaftarId}"
}

@Composable
private fun ItemDetailsBody(
    detailUIState: DetailUIState,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
){

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