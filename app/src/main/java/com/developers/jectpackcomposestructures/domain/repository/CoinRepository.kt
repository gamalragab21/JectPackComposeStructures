package com.developers.jectpackcomposestructures.domain.repository

import com.developers.jectpackcomposestructures.data.remote.dto.CoinDetailsDto
import com.developers.jectpackcomposestructures.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailsDto

}