package com.dee.android.feature_order.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dee.android.feature_order.data.OrderRepositoryImpl
import com.dee.android.feature_order.domain.usecase.GetOrdersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OrderViewModel : ViewModel() {

    private val useCase = GetOrdersUseCase(OrderRepositoryImpl())

    private val _uiState = MutableStateFlow(OrderUiState())
    val uiState: StateFlow<OrderUiState> = _uiState

    fun onEvent(event: OrderEvent) {
        when (event) {
            OrderEvent.LoadOrders -> loadOrders()
        }
    }

    private fun loadOrders() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val orders = useCase()

            _uiState.update {
                it.copy(
                    isLoading = false,
                    orders = orders.map { order ->
                        "Order #${order.id} - $${order.amount}"
                    }
                )
            }
        }
    }
}