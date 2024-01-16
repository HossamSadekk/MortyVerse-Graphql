package com.example.common.use_case

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

sealed class DataState<out T> {
    data class Success<out T>(val result: T) : DataState<T>()
    data class Error(val error: Throwable) : DataState<Nothing>()
}
abstract class UseCase<ReturnType> where ReturnType : Any {
    
    protected abstract suspend fun FlowCollector<DataState<ReturnType>>.execute(parameter: String? = null)
    
    suspend operator fun invoke(parameter: String? = null) = flow {
        execute(parameter)
    }.flowOn(Dispatchers.IO)
}

suspend fun <T : Any> apiCall(call: suspend () -> T): DataState<T> {
    return try {
        val response = call()
        DataState.Success(response)
    } catch (ex: Throwable) {
        DataState.Error(ex)
    }
}
