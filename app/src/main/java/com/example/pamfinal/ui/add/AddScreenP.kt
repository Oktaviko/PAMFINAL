package com.example.pamfinal.ui.add

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pamfinal.AddEvent
import com.example.pamfinal.navigation.DestinasiNavigasi

object DestinasiEntry : DestinasiNavigasi {
    override val route = "item_entry"
    override val titleRes = "Entry Customer"
}
@Composable
fun FormInput(
    addEvent: AddEvent,
    modifier: Modifier = Modifier,
    onValueChange: (AddEvent) -> Unit = {},
    enabled: Boolean = true
){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ){

    }
}