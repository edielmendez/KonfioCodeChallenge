package mx.com.edieltech.konfiocodechallenge.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.com.edieltech.konfiocodechallenge.presentation.navigation.routes.HomeRoute
import mx.com.edieltech.konfiocodechallenge.presentation.screens.home.HomeScreen

@Composable
fun MainNavGraph(
    startDestination: HomeRoute = HomeRoute,
    onExitApp: () -> Unit
){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ){
        composable<HomeRoute> { backStackEntry ->
            HomeScreen(
                onExitApp = onExitApp
            )
        }
    }
}