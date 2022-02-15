package com.developers.jectpackcomposestructures.presentation_layer.coin_datils.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developers.jectpackcomposestructures.common.Constants.PARAM_COIN_ID
import com.developers.jectpackcomposestructures.common.helpers.Resource
import com.developers.jectpackcomposestructures.domain.use_case.get_coins.GetCoinUseCase
import com.developers.jectpackcomposestructures.presentation_layer.coin_datils.state.CoinDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _coinState = mutableStateOf(CoinDetailsState())
    val coinState: State<CoinDetailsState> = _coinState


    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(coinId:String) {
        viewModelScope.launch {
            getCoinUseCase(coinId).onEach {
                when (it) {
                    is Resource.Success -> {
                        _coinState.value = CoinDetailsState(coin = it.data)
                    }
                    is Resource.Error -> {
                        _coinState.value = CoinDetailsState(error = it.message?:"")
                    }
                    is Resource.Loading -> {
                        _coinState.value = CoinDetailsState(isLoading = true)
                    }
                }
            }.launchIn(viewModelScope)

        }
    }

}



