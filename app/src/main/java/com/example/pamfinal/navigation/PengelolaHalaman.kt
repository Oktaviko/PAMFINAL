package com.example.pamfinal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pamfinal.ui.DestinasiUtama
import com.example.pamfinal.ui.HalamanUtama
import com.example.pamfinal.ui.add.AddScreenPendaftar
import com.example.pamfinal.ui.add.DestinasiEntryP
import com.example.pamfinal.ui.add.EntryBodyP
import com.example.pamfinal.ui.home.DestinasiHomePendaftar
import com.example.pamfinal.ui.home.HomeScreenPendaftar

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiUtama.route,
        modifier = Modifier
    ){
        composable(DestinasiUtama.route){
            HalamanUtama(
                onPendaftarClick = {navController.navigate(DestinasiHomePendaftar.route)},
                onRumahSakitClick = {}
            )
        }
        composable(DestinasiHomePendaftar.route){
            HomeScreenPendaftar(navigateToItemEntry = {
                navController.navigate(DestinasiEntryP.route)
            },
                onDetailClick = {}
            )
        }
        composable(DestinasiEntryP.route){
            AddScreenPendaftar(navigateBack = {
                navController.navigate(DestinasiHomePendaftar.route)
            })
        }
    }
}