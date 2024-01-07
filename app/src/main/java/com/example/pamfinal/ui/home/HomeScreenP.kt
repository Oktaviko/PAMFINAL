package com.example.pamfinal.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi

object DestinasiHomePendaftar : DestinasiNavigasi{
    override val route = "home_pendaftar"
    override val titleRes = "Pendaftar"
}

@Composable
fun BodyHomePendaftar(
    itemPendaftar: List<Pendaftar>,
    modifier: Modifier = Modifier,
    onCustomerClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemPendaftar.isEmpty()) {
            Text(
                text = "Tidak ada data Pendaftar",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListPendaftar(
                itemPendaftar = itemPendaftar,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onCustomerClick(it.nik) }
            )
        }
    }
}
@Composable
fun ListPendaftar(
    itemPendaftar: List<Pendaftar>,
    modifier: Modifier = Modifier,
    onItemClick: (Pendaftar) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemPendaftar, key = { it.nik}) { pendaftar ->
            DataPendaftar(
                pendaftar = pendaftar,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(pendaftar) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun DataPendaftar(
    pendaftar: Pendaftar,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pendaftar.nama,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
                Text(
                    text = pendaftar.telepon,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Text(
                text = pendaftar.alamat,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}