package com.dee.android.feature_order.domain.repository

import com.dee.android.feature_order.domain.model.Order

interface OrderRepository {
    suspend fun getOrders(): List<Order>
}