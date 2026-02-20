package com.dee.android.feature_order

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dee.android.feature_order.ui.OrderScreen

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