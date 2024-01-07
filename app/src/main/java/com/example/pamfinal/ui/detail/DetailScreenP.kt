package com.example.pamfinal.ui.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details_pendaftar"
    override val titleRes = "Detail Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "$route/{$pendaftarId}"
}

@Composable
fun ItemDetailsPendaftar(
    pendaftar: Pendaftar,
    modifier: Modifier = Modifier
){

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