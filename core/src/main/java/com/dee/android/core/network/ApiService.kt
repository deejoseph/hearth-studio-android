package com.dee.android.core.network

import com.dee.android.core.model.BaseResponse
import retrofit2.http.GET

interface ApiService {

    @GET("test")
    suspend fun test(): BaseResponse<String>

}