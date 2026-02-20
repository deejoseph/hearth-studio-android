package com.dee.android.feature_home

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dee.android.feature_home.ui.HomeScreen

object HomeDestination {
    const val route = "home"
}

fun NavGraphBuilder.homeScreen() {
    composable(route = HomeDestination.route) {
        HomeRoute()
    }
}

@Composable
fun HomeRoute() {
    HomeScreen()
}