package com.dee.android.core.network

import com.dee.android.core.model.BaseResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend fun <T> safeApiCall(
    apiCall: suspend () -> BaseResponse<T>
): NetworkResult<T> {

    return withContext(Dispatchers.IO) {
        try {
            val response = apiCall()

            if (response.code == 200 && response.data != null) {
                NetworkResult.Success(response.data)
            } else {
                NetworkResult.Error(response.message)
            }

        } catch (e: Exception) {
            NetworkResult.Error(e.message ?: "Unknown Error")
        }
    }
}
