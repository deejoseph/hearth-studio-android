package com.dee.android.feature_order.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun OrderScreen(
    viewModel: OrderViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.onEvent(OrderEvent.LoadOrders)
    }

    Column {
        state.orders.forEach {
            Text(text = it)
        }
    }
}