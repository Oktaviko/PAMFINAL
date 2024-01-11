package com.example.pamfinal.ui.add

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.R
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.AddEventKartuBpjs
import com.example.pamfinal.ui.AddEventPendaftar
import com.example.pamfinal.ui.AddUIStateKartuBpjs
import com.example.pamfinal.ui.AddUIStatePendaftar
import com.example.pamfinal.ui.BPJSTopAppBar
import com.example.pamfinal.ui.PenyediaViewModel
import kotlinx.coroutines.launch
import kotlin.reflect.KFunction1

object DestinasiEntryK : DestinasiNavigasi {
    override val route = "item_entry_kartu"
    override val titleRes = "Entry Kartu"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreenKartu(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addViewModel: AddViewModelKartu = viewModel(factory = PenyediaViewModel.Factory),
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BPJSTopAppBar(title = DestinasiEntryK.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Image(painter = painterResource(
                id = R.drawable.halaman),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            EntryBodyK(
                addUIState = addViewModel.addUIStateKartu,
                onKartuValueChange = addViewModel::updateAddUIState,
                onSaveClick = {
                    coroutineScope.launch {
                        addViewModel.addKartu()
                        navigateBack()
                    }
                },
                modifier = Modifier
                    .padding(innerPadding)
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth()
            )
        }
    }

}

@Composable
fun EntryBodyK(
    addUIState: AddUIStateKartuBpjs,
    onKartuValueChange: (AddEventKartuBpjs) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier.padding(15.dp)
    ){
        FormInputK(
            addEvent = addUIState.addEventKartuBpjs,
            onValueChange = onKartuValueChange,
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = onSaveClick,
            shape = MaterialTheme.shapes.small,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Submit")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputK(
    addEvent: AddEventKartuBpjs,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventKartuBpjs) -> Unit = {},
    enabled: Boolean = true
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        OutlinedTextField(
            value = addEvent.pendaftar,
            onValueChange = { onValueChange(addEvent.copy(pendaftar = it)) },
            label = { Text("Nama Pendaftar") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.rumahSakit,
            onValueChange = { onValueChange(addEvent.copy(rumahSakit = it)) },
            label = { Text("Nama Rumah Sakit") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.masa_aktif,
            onValueChange = { onValueChange(addEvent.copy(masa_aktif = it)) },
            label = { Text("Masa Aktif Kartu") },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}