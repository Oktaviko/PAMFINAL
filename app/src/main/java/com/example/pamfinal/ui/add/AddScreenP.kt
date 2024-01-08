package com.example.pamfinal.ui.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pamfinal.ui.PenyediaViewModel
import com.example.pamfinal.navigation.DestinasiNavigasi
import com.example.pamfinal.ui.AddEventPendaftar
import com.example.pamfinal.ui.AddUIStatePendaftar
import com.example.pamfinal.ui.BPJSTopAppBar
import kotlinx.coroutines.launch

object DestinasiEntryP : DestinasiNavigasi {
    override val route = "item_entry_pendaftar"
    override val titleRes = "Entry Pendaftar"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreenPendaftar(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addViewModel: AddViewModelPendaftar = viewModel(factory = PenyediaViewModel.Factory),
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BPJSTopAppBar(title = DestinasiEntryP.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){innerPadding ->

        EntryBodyP(
            addUIState = addViewModel.addUIStatePendftar,
            onCustomerValueChange = addViewModel::updateAddUIState,
            onSaveClick = {
                coroutineScope.launch {
                    addViewModel.addPendaftar()
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

@Composable
fun EntryBodyP(
    addUIState: AddUIStatePendaftar,
    onCustomerValueChange: (AddEventPendaftar) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier.padding(15.dp)
    ){
        FormInputP(
            addEvent = addUIState.addEventPendaftar,
            onValueChange = onCustomerValueChange,
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
fun FormInputP(
    addEvent: AddEventPendaftar,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventPendaftar) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        OutlinedTextField(
            value = addEvent.nama,
            onValueChange = {onValueChange(addEvent.copy(nama = it))},
            label ={Text("Nama")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.nik,
            onValueChange = {onValueChange(addEvent.copy(nik = it))},
            label ={Text("NIK")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.alamat,
            onValueChange = {onValueChange(addEvent.copy(alamat = it))},
            label ={Text("Alamat")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.tanggal_lahir,
            onValueChange = {onValueChange(addEvent.copy(tanggal_lahir = it))},
            label ={Text("Tanggal Lahir")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.telepon,
            onValueChange = {onValueChange(addEvent.copy(telepon = it))},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label ={Text("Telepon")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}