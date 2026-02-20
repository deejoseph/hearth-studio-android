package com.dee.android.hearthstudio.navigation

import com.dee.android.core.navigation.AppRoute

/**
 * Root Nav Graph
 */
object RootDestination : AppRoute {
    override val route: String = "root"
}

/**
 * Main Graph (Bottom Navigation container)
 */
object MainGraphRoute : AppRoute {
    override val route: String = "main_graph"
}