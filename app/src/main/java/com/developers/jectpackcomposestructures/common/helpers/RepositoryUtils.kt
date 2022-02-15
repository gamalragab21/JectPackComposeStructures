package com.developers.jectpackcomposestructures.common.helpers

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


inline  fun <T> safeCall(action: () -> Resource<T>):Resource<T>{
    return try {
        action()
    } catch (e: Exception) {
        Resource.Error(e.message ?: "An unknown error occurred")
    }
}

//inline fun <T> safeNavigate(action: () -> T): T {
//    return try {
//        action()
//    } catch(e: Exception) {
//        ""
//    }
//}










