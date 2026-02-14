package com.dee.android.core.model

data class BaseResponse<T>(
    val code: Int,
    val message: String,
    val data: T?
)
