package com.dee.android.feature_order.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dee.android.feature_order.presentation.OrderScreen

object OrderDestination {
    const val route = "order"
}

fun NavGraphBuilder.orderScreen() {
    composable(route = OrderDestination.route) {
        OrderRoute()
    }
}

@Composable
fun OrderRoute() {
    OrderScreen()
}