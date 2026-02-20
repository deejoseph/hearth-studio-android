package com.dee.android.feature_order.presentation

sealed interface OrderEvent {
    data object LoadOrders : OrderEvent
}