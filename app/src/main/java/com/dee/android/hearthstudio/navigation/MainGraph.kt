package com.dee.android.hearthstudio.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.dee.android.feature_home.HomeDestination
import com.dee.android.feature_home.homeScreen
import com.dee.android.feature_order.navigation.orderScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dee.android.core.navigation.AppRoute

object MainContainerRoute : AppRoute {
    override val route: String = "main_container"
}

@Composable
private fun ComposableContainer(
    rootNavController: NavController
) {

    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = bottomNavController
            )
        }
    ) { paddingValues ->

        NavHost(
            navController = bottomNavController,
            startDestination = HomeDestination.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            homeScreen()
            orderScreen()
        }
    }
}

fun NavGraphBuilder.mainGraph(
    rootNavController: NavController
) {

    navigation(
        route = MainGraphRoute.route,
        startDestination = MainContainerRoute.route
    ) {

        composable("main_container") {
            ComposableContainer(rootNavController)
        }
    }
}