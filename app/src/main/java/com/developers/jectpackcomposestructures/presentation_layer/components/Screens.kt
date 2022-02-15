package com.developers.jectpackcomposestructures.presentation_layer.components

sealed class Screens (val name:String,val route:String){

    object CoinListScreen:Screens("CoinListScreen","coin_list_screen")
    object CoinDetailsScreen:Screens("CoinDetailsScreen","coin_details_screen")

}