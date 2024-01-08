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
import com.example.pamfinal.ui.AddEventRS
import com.example.pamfinal.ui.AddUIStatePendaftar
import com.example.pamfinal.ui.AddUIStateRS
import com.example.pamfinal.ui.BPJSTopAppBar
import kotlinx.coroutines.launch

object DestinasiEntryR : DestinasiNavigasi {
    override val route = "item_entry_rs"
    override val titleRes = "Entry Rumah Sakit"
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreenRumahSakit(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
    addViewModel: AddViewModelRS = viewModel(factory = PenyediaViewModel.Factory),
){
    val coroutineScope = rememberCoroutineScope()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            BPJSTopAppBar(title = DestinasiEntryR.titleRes,
                canNavigateBack = true,
                scrollBehavior = scrollBehavior,
                navigateUp = navigateBack
            )
        }
    ){innerPadding ->

        EntryBodyR(
            addUIState = addViewModel.addUIStateRS,
            onRSValueChange = addViewModel::updateAddUIState,
            onSaveClick = {
                coroutineScope.launch {
                    addViewModel.addRS()
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
fun EntryBodyR(
    addUIState: AddUIStateRS,
    onRSValueChange: (AddEventRS) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        verticalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier.padding(15.dp)
    ){
        FormInputR(
            addEvent = addUIState.addEventRS,
            onValueChange = onRSValueChange,
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
fun FormInputR(
    addEvent: AddEventRS,
    modifier: Modifier = Modifier,
    onValueChange: (AddEventRS) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){
        OutlinedTextField(
            value = addEvent.nama_rs,
            onValueChange = {onValueChange(addEvent.copy(nama_rs = it))},
            label ={Text("Nama Rumah Sakit")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.id_rs,
            onValueChange = {onValueChange(addEvent.copy(id_rs = it))},
            label ={Text("id rs")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
        OutlinedTextField(
            value = addEvent.alamat_rs,
            onValueChange = {onValueChange(addEvent.copy(alamat_rs = it))},
            label ={Text("Alamat Rumah Sakit")},
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )
    }
}