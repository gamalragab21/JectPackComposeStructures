package com.developers.jectpackcomposestructures.domain.use_case.get_coin

import com.developers.jectpackcomposestructures.common.helpers.Event
import com.developers.jectpackcomposestructures.common.helpers.Resource
import com.developers.jectpackcomposestructures.common.helpers.safeCall
import com.developers.jectpackcomposestructures.data.remote.dto.toCoin
import com.developers.jectpackcomposestructures.domain.model.Coin
import com.developers.jectpackcomposestructures.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository,
) {

    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        emit(Resource.Loading())
        val result = safeCall {
            val coins = repository.getCoins().map {
                it.toCoin()
            }
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