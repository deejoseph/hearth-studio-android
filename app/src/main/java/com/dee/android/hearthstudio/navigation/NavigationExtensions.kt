package com.dee.android.hearthstudio.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder
import com.dee.android.core.navigation.AppRoute

/**
 * Type-safe navigation
 */
fun NavController.navigate(
    route: AppRoute,
    builder: NavOptionsBuilder.() -> Unit = {}
) {
    this.navigate(route.route, builder)
}