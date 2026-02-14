package com.dee.android.feature_home.data

import com.dee.android.core.network.NetworkResult
import com.dee.android.core.network.RetrofitClient
import com.dee.android.core.network.safeApiCall

class HomeRepository {

    suspend fun loadData(): NetworkResult<String> {
        return safeApiCall {
            RetrofitClient.api.test()
        }
    }
}
