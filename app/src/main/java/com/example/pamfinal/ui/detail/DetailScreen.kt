package com.example.pamfinal.ui.detail

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pamfinal.model.Pendaftar
import com.example.pamfinal.navigation.DestinasiNavigasi
import kotlinx.coroutines.launch

object DetailDestination : DestinasiNavigasi {
    override val route = "item_details"
    override val titleRes = "Detail Pendaftar"
    const val pendaftarId = "itemId"
    val routeWithArgs = "$route/{$pendaftarId}"
}
