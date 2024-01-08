package com.example.pamfinal.ui


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pamfinal.navigation.DestinasiNavigasi

object DestinasiUtama : DestinasiNavigasi {
    override val route = "menu"
    override val titleRes = "MENU"
}
@Composable
fun HalamanUtama(
onPendaftarClick: () -> Unit,
onRumahSakitClick: () -> Unit,
) {
    Row (
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ){
        Text(text = "MENU", style = MaterialTheme.typography.titleLarge)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("DATA PENDAFTAR", style = MaterialTheme.typography.titleMedium)
            }

            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("DATA RUMAH_SAKIT", style = MaterialTheme.typography.titleMedium)
            }

            Button(
                onClick = { /* Handle button click */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Text("KARTU_BPJS", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}