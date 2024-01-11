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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pamfinal.navigation.DestinasiNavigasi

object DestinasiUtama : DestinasiNavigasi {
    override val route = "menu"
    override val titleRes = "PILIHAN MENU"
}
@Composable
fun HalamanUtama(
onPendaftarClick: () -> Unit,
onRumahSakitClick: () -> Unit,
onKartuBPJSClick: () -> Unit,
navigateBack: () -> Unit,
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
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
                onClick =  onPendaftarClick ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Blue
                )
            ) {
                Text("DATA PENDAFTAR", style = MaterialTheme.typography.titleMedium)
            }

            Button(
                onClick = onRumahSakitClick ,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Blue
                )
            ) {
                Text("DATA RUMAH SAKIT", style = MaterialTheme.typography.titleMedium)
            }

            Button(
                onClick = onKartuBPJSClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    Color.Blue
                )
            ) {
                Text("KARTU BPJS", style = MaterialTheme.typography.titleMedium)
            }
        }
    }
}