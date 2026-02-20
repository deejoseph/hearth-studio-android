package com.dee.android.feature_order.data

import com.dee.android.feature_order.domain.model.Order
import com.dee.android.feature_order.domain.repository.OrderRepository
import kotlinx.coroutines.delay

class OrderRepositoryImpl : OrderRepository {

    override suspend fun getOrders(): List<Order> {
        delay(500) // 模拟网络
        return listOf(
            Order(id = "1001", amount = 120.0),
            Order(id = "1002", amount = 80.0)
        )
    }
}