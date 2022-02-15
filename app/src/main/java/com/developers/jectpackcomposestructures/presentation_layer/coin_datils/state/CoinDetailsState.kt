package com.developers.jectpackcomposestructures.presentation_layer.coin_datils.state

import com.developers.jectpackcomposestructures.domain.model.Coin
import com.developers.jectpackcomposestructures.domain.model.CoinDetail

data class CoinDetailsState (
    val isLoading: Boolean = false,
    val coin: CoinDetail?=null,
    val error: String = ""
)