package com.example.pamfinal.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.R
import com.example.pamfinal.model.Kartu
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.PenyediaViewModel
import com.example.pamfinal.ui.add.EntryBodyK
import kotlinx.coroutines.launch

object DestinasiHomeKartu : DestinasiNavigasi {
    override val route = "home_kartu"
    override val titleRes = "Kartu BPJS"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenKartu(
    navigateToItemEntry: () -> Unit,
    modifier: Modifier = Modifier,
    onDetailClick: (String) -> Unit = {},
    viewModel: HomeViewModelKartu = viewModel(factory = PenyediaViewModel.Factory)
) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BPJSTopAppBar(
                title = "Kartu",
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
        val uiStateKartu by viewModel.homeUIStateK.collectAsState()
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Image(painter = painterResource(
                id = R.drawable.raul),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            BodyHomeKartu(
                itemKartu = uiStateKartu.listKartu,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize(),
                onKartuClick = onDetailClick
            )
        }
    }
}
@Composable
fun BodyHomeKartu(
    itemKartu: List<Kartu>,
    modifier: Modifier = Modifier,
    onKartuClick: (String) -> Unit = {}
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (itemKartu.isEmpty()) {
            Text(
                text = "Tidak ada data Kartu BPJS",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
        } else {
            ListKartu(
                itemKartu = itemKartu,
                modifier = Modifier
                    .padding(horizontal = 8.dp),
                onItemClick = { onKartuClick(it.id_kartu) }
            )
        }
    }
}
@Composable
fun ListKartu(
    itemKartu: List<Kartu>,
    modifier: Modifier = Modifier,
    onItemClick: (Kartu) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        this.items(itemKartu, key = { it.id_kartu}) { kartu ->
            DataKartuBPJS(
                kartu= kartu,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onItemClick(kartu) }
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}
@Composable
fun DataKartuBPJS(
    kartu: Kartu,
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
            Text(
                text = kartu.pendaftar,
                style = MaterialTheme.typography.titleLarge,
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = kartu.id_kartu,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = kartu.rumahSakit,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = kartu.masa_Aktif,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}