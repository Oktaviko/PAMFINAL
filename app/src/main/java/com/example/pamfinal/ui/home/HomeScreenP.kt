package com.example.pamfinal.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSApp
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.PenyediaViewModel

object DestinasiHomePendaftar : DestinasiNavigasi{
    override val route = "home_pendaftar"
    override val titleRes = "Pendaftar"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenPendaftar(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HomeViewModelPendaftar = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BPJSTopAppBar(
                title = "Pendaftar",
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToItemEntry,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(18.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
    ) { innerPadding ->
        val uiStateSiswa by viewModel.homeUIState.collectAsState()
        BodyHomePendaftar(
            itemPendaftar = uiStateSiswa.listPendaftar,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onCustomerClick = onDetailClick
        )
    }
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