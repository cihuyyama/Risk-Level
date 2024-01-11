package com.example.risklevel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.consumerestapi.navigation.DestinasiNavigasi
import com.example.risklevel.data.ApiService
import com.example.risklevel.ui.auth.DestinasiLogin
import com.example.risklevel.ui.auth.LoginScreen
import com.example.risklevel.ui.main.DestinasiHome
import com.example.risklevel.utils.SessionManager

@Composable
fun PengelolaHalaman(navController: NavHostController = rememberNavController()){
NavHost(
navController = navController,
startDestination = DestinasiLogin.route,
    modifier = Modifier,
) {
composable(DestinasiLogin.route) {
    LoginScreen(
        navigateHome = {
            navController.navigate(
            )
        }
    )
}
    composable(DestinasiHome.route){
        HomeS
    }
}
}