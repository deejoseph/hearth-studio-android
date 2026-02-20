package com.dee.android.feature_order.domain.usecase

import com.dee.android.feature_order.domain.repository.OrderRepository

class GetOrdersUseCase(
    private val repository: OrderRepository
) {
    suspend operator fun invoke() = repository.getOrders()
}