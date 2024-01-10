package com.example.pamfinal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pamfinal.ui.DestinasiUtama
import com.example.pamfinal.ui.HalamanUtama
import com.example.pamfinal.ui.add.AddScreenPendaftar
import com.example.pamfinal.ui.add.DestinasiEntryP
import com.example.pamfinal.ui.add.DestinasiEntryR
import com.example.pamfinal.ui.detail.DetailDestinationPendaftar
import com.example.pamfinal.ui.detail.DetailScreenPendaftar
import com.example.pamfinal.ui.edit.EditDestinationPendaftar
import com.example.pamfinal.ui.home.DestinasiHomePendaftar
import com.example.pamfinal.ui.home.DestinasiHomeRumahSakit
import com.example.pamfinal.ui.home.HomeScreenPendaftar
import com.example.pamfinal.ui.home.HomeScreenRumahSakit

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
                onRumahSakitClick = {navController.navigate(DestinasiHomeRumahSakit.route)}
            )
        }
        composable(DestinasiHomePendaftar.route){
            HomeScreenPendaftar(navigateToItemEntry = {
                navController.navigate(DestinasiEntryP.route)
            },
                onDetailClick = {
                    navController.navigate((DetailDestinationPendaftar.route))
                }
            )
        }
        composable(
            route = DetailDestinationPendaftar.routeWithArgs,
            arguments = listOf(navArgument(DetailDestinationPendaftar.pendaftarId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val pendaftarId = backStackEntry.arguments?.getString(DetailDestinationPendaftar.pendaftarId)
            pendaftarId?.let {
                DetailScreenPendaftar(
                    navigateToEditItem = {
                                         navController.navigate("${EditDestinationPendaftar.route}/$pendaftarId")
                        println("pendaftarId: $pendaftarId")
                    },
                    navigateBack = { navController.popBackStack() })
            }
        }
        composable(DestinasiEntryP.route){
            AddScreenPendaftar(navigateBack = {
                navController.navigate(DestinasiHomePendaftar.route)
            })
        }

        composable(DestinasiEntryR.route){
            HomeScreenRumahSakit(navigateToItemEntry = {
                navController.navigate(DestinasiEntryR.route) },
                onDetailClick = {}
                )
        }
    }
}