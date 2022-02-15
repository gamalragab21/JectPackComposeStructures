package com.developers.jectpackcomposestructures.presentation_layer.coin_list.state

import com.developers.jectpackcomposestructures.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)