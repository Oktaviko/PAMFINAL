package com.example.pamfinal.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pamfinal.ui.DestinasiLogin
import com.example.pamfinal.ui.DestinasiUtama
import com.example.pamfinal.ui.HalamanUtama
import com.example.pamfinal.ui.LoginScreen
import com.example.pamfinal.ui.add.AddScreenPendaftar
import com.example.pamfinal.ui.add.AddScreenRumahSakit
import com.example.pamfinal.ui.add.DestinasiEntryP
import com.example.pamfinal.ui.add.DestinasiEntryR
import com.example.pamfinal.ui.detail.DetailDestinationPendaftar
import com.example.pamfinal.ui.detail.DetailDestinationRumahSakit
import com.example.pamfinal.ui.detail.DetailScreenPendaftar
import com.example.pamfinal.ui.detail.DetailScreenRumahSakit
import com.example.pamfinal.ui.edit.EditDestinationPendaftar
import com.example.pamfinal.ui.edit.EditDestinationRumahSakit
import com.example.pamfinal.ui.edit.EditScreenPendaftar
import com.example.pamfinal.ui.edit.EditScreenRumahSakit
import com.example.pamfinal.ui.home.DestinasiHomeKartu
import com.example.pamfinal.ui.home.DestinasiHomePendaftar
import com.example.pamfinal.ui.home.DestinasiHomeRumahSakit
import com.example.pamfinal.ui.home.HomeScreenKartu
import com.example.pamfinal.ui.home.HomeScreenPendaftar
import com.example.pamfinal.ui.home.HomeScreenRumahSakit

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = DestinasiLogin.route,
        modifier = Modifier
    ){
        composable(DestinasiLogin.route){
            LoginScreen(navController)
        }
        composable(DestinasiUtama.route){
            HalamanUtama(
                onPendaftarClick = {navController.navigate(DestinasiHomePendaftar.route)},
                onRumahSakitClick = {navController.navigate(DestinasiHomeRumahSakit.route)},
                onKartuBPJSClick = {navController.navigate(DestinasiHomeKartu.route)}
            )
        }
        composable(DestinasiHomePendaftar.route){
            HomeScreenPendaftar(navigateToItemEntry = {
                navController.navigate(DestinasiEntryP.route)
            },
                onDetailClick = {
                        pendaftarId ->
                    navController.navigate("${DetailDestinationPendaftar.route}/$pendaftarId")
                    println("itemId: $pendaftarId")
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
                        println("itemId: $pendaftarId")
                    },
                    navigateBack = { navController.popBackStack() })
            }
        }
        composable(DestinasiEntryP.route){
            AddScreenPendaftar(navigateBack = {
                navController.popBackStack() }
            )
        }
        composable(
            route = EditDestinationPendaftar.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationPendaftar.pendaftarId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val pendaftarId = backStackEntry.arguments?.getString(EditDestinationPendaftar.pendaftarId)
            pendaftarId?.let {
                EditScreenPendaftar(
                    navigateBack = { navController.popBackStack() },
                    onNavigateUp = { navController.navigateUp() })
            }
        }
        composable(DestinasiHomeRumahSakit.route){
            HomeScreenRumahSakit(navigateToItemEntry = {
                navController.navigate(DestinasiEntryR.route)
            },
                onDetailClick = {
                        rumahsakitId ->
                    navController.navigate("${DetailDestinationRumahSakit.route}/$rumahsakitId")
                    println("itemrumahsakitId: $rumahsakitId")
                }
            )
        }
        composable(
            route = DetailDestinationRumahSakit.routeWithArgs,
            arguments = listOf(navArgument(DetailDestinationRumahSakit.rumahsakitId){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val rumahsakitId = backStackEntry.arguments?.getString(DetailDestinationRumahSakit.rumahsakitId)
            rumahsakitId?.let {
                DetailScreenRumahSakit(
                    navigateToEditItem = {
                        navController.navigate("${EditDestinationRumahSakit.route}/$rumahsakitId")
                        println("itemrumahsakitId: $rumahsakitId")
                    },
                    navigateBack = { navController.popBackStack() })
            }
        }
        composable(DestinasiEntryR.route){
            AddScreenRumahSakit(navigateBack = {
                navController.popBackStack()
            })
        }
        composable(
            route = EditDestinationRumahSakit.routeWithArgs,
            arguments = listOf(navArgument(EditDestinationRumahSakit.rumahsakitId) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val rumahSakitId = backStackEntry.arguments?.getString(EditDestinationRumahSakit.rumahsakitId)
            rumahSakitId?.let {
                EditScreenRumahSakit(
                    navigateBack = { navController.popBackStack() },
                    onNavigateUp = { navController.navigateUp() })
            }
        }
        composable(DestinasiHomeKartu.route){
            HomeScreenKartu(navigateToItemEntry = { /*TODO*/ })
        }
    }
}