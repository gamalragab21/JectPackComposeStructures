package com.developers.jectpackcomposestructures.presentation_layer.coin_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developers.jectpackcomposestructures.common.helpers.Resource
import com.developers.jectpackcomposestructures.domain.use_case.get_coin.GetCoinsUseCase
import com.developers.jectpackcomposestructures.presentation_layer.coin_list.state.CoinListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
) : ViewModel() {

    private val _coinState = mutableStateOf(CoinListState())
    val coinState: State<CoinListState> = _coinState


    init {
        getCoins()
    }

    private fun getCoins() {
        viewModelScope.launch {
            getCoinsUseCase().onEach {
                when (it) {
                    is Resource.Success -> {
                        _coinState.value = CoinListState(coins = it.data?: emptyList())
                    }
                    is Resource.Error -> {
                        _coinState.value = CoinListState(error = it.message?:"")
                    }
                    is Resource.Loading -> {
                        _coinState.value = CoinListState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)

        }
    }

}



