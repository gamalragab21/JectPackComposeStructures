package com.developers.jectpackcomposestructures.presentation_layer.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.developers.jectpackcomposestructures.common.Constants.PARAM_COIN_ID
import com.developers.jectpackcomposestructures.presentation_layer.coin_datils.components.CoinDetailsScreen
import com.developers.jectpackcomposestructures.presentation_layer.coin_list.components.CoinListScreen

@Composable
fun MySetupNavGraph(navController: NavHostController) {
    NavHost(
        navController,
        startDestination = Screens.CoinListScreen.route) {

        composable(Screens.CoinListScreen.route) {
            CoinListScreen(navController = navController)
        }
        composable(Screens.CoinDetailsScreen.route+"/{$PARAM_COIN_ID}") {
            CoinDetailsScreen()
        }
    }
}