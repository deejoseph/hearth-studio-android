package com.dee.android.hearthstudio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.dee.android.feature_home.HomeDestination

@Composable
fun AppNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MainGraphRoute.route
    ) {

        // 主流程
        mainGraph(navController)

        // 未来登录流程
        // authGraph(navController)
    }
}

private val bottomItems = listOf(
    BottomDestination(
        route = HomeDestination.route,
        label = "Home"
    ),
    BottomDestination(
        route = "order", // 如果你有 OrderDestination 就用它
        label = "Order"
    )
)