package com.developers.jectpackcomposestructures.domain.use_case.get_coins

import com.developers.jectpackcomposestructures.common.helpers.Resource
import com.developers.jectpackcomposestructures.common.helpers.safeCall
import com.developers.jectpackcomposestructures.data.remote.dto.toCoinDetails
import com.developers.jectpackcomposestructures.domain.model.CoinDetail
import com.developers.jectpackcomposestructures.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository,
) {

    operator fun invoke(coinId:String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        val result = safeCall {
            val coins = repository.getCoinById(coinId =coinId ).toCoinDetails()
            Resource.Success(coins)
        }
        emit(result)
//        try {
//            emit(Resource.Loading())
//            val coins = repository.getCoins().map {
//                it.toCoin()
//            }
//            emit(Resource.Success(coins))
//        } catch (e: HttpException) {
//            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
//        } catch (e: IOException) {
//            emit(Resource.Error(e.localizedMessage ?: "An unknown error occurred"))
//        }
    }
}