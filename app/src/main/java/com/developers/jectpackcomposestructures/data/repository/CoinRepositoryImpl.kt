package com.developers.jectpackcomposestructures.data.repository

import com.developers.jectpackcomposestructures.data.remote.CoinPaprikaApi
import com.developers.jectpackcomposestructures.data.remote.dto.CoinDetailsDto
import com.developers.jectpackcomposestructures.data.remote.dto.CoinDto
import com.developers.jectpackcomposestructures.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) :CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {

        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoins(coinId)
    }
}