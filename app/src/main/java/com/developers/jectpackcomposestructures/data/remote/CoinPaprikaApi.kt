package com.developers.jectpackcomposestructures.data.remote

import com.developers.jectpackcomposestructures.common.Constants.GET_COIN
import com.developers.jectpackcomposestructures.common.Constants.GET_COINS
import com.developers.jectpackcomposestructures.data.remote.dto.CoinDetailsDto
import com.developers.jectpackcomposestructures.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET(GET_COINS)
    suspend fun getCoins():List<CoinDto>

    @GET(GET_COIN)
    suspend fun getCoins(@Path("coinId") coinId:String):CoinDetailsDto
}