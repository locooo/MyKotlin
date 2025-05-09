package com.example.mykotlin

import com.example.mykotlin.viewModeDemo.Page1
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun AppNavController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = RouteConfig.ROUTE_PAGE_HOME) {
        composable(RouteConfig.ROUTE_PAGE_HOME) {
            PageHome(navController)
        }
        composable(RouteConfig.ROUTE_PAGE_ONE) {
            Page1(navController)
        }


        composable(RouteConfig.ROUTE_PAGE_TEST) {
            PageTest(navController)
        }
    }

}


object RouteConfig {
    /**
     * 主页面
     */
    const val ROUTE_PAGE_HOME = "PageHome"

    /**
     * 页面1
     */
    const val ROUTE_PAGE_ONE = "Page1"

    const val ROUTE_PAGE_TEST = "PageTest"
}