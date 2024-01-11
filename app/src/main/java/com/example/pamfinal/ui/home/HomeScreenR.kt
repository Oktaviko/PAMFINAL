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
import com.example.pamfinal.model.RumahSakit
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.PenyediaViewModel

object DestinasiHomeRumahSakit : DestinasiNavigasi {
    override val route = "home_rumahsakit"
    override val titleRes = "RumahSakit"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenRumahSakit(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HomeViewModelRumahSakit = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BPJSTopAppBar(
                title = "RumahSakit",
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
        val uiStateRumahSakit by viewModel.homeUIStateR.collectAsState()
        BodyHomeRumahSakit(
            itemRumahSakit = uiStateRumahSakit.listRumahSakit,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            onRSClick = onDetailClick
        )
    }
}
@Composable
fun BodyHomeRumahSakit(
    itemRumahSakit: List<RumahSakit>,
    modifier: Modifier = Modifier,
    onRSClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemRumahSakit.isEmpty()) {
            Text(
                text = "Tidak ada data RumahSakit",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListRumahSakit(
                itemRumahSakit = itemRumahSakit,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onRSClick(it.id_rs) }
            )
        }
    }
}
@Composable
fun ListRumahSakit(
    itemRumahSakit: List<RumahSakit>,
    modifier: Modifier = Modifier,
    onItemClick: (RumahSakit) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemRumahSakit, key = { it.id_rs}) { rumahsakit ->
            DataRumahSakit(
                rumahsakit = rumahsakit,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(rumahsakit) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun DataRumahSakit(
    rumahsakit: RumahSakit,
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
                    text = rumahsakit.nama_rs,
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Phone,
                    contentDescription = null,
                )
            }
            Text(
                text = rumahsakit.alamat_rs,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}