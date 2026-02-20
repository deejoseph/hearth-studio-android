package com.dee.android.feature_order.presentation

data class OrderUiState(
    val isLoading: Boolean = false,
    val orders: List<String> = emptyList(),
    val error: String? = null
)