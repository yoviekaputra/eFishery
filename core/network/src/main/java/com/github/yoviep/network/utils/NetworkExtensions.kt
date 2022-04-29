package com.github.yoviep.network.utils

import com.github.yoviep.network.models.ApiResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


/**
 * @created 30-04-2022 06:37
 * @author yoviekaputra
 * @project eFishery
 **/

fun <T> safeApiCall(dispatcher: CoroutineDispatcher, apiCall: suspend () -> T): Flow<ApiResult<T>> {
    return flow<ApiResult<T>> {
        val call = apiCall.invoke()
        emit(ApiResult.Success(call))
    }.catch { throwable ->
        emit(ApiResult.Error(throwable))
    }.flowOn(dispatcher)
}
