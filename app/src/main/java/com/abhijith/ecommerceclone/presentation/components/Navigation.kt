package com.abhijith.ecommerceclone.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.ImageLoader
import com.abhijith.ecommerceclone.presentation.account.AccountScreen
import com.abhijith.ecommerceclone.presentation.cart.CartScreen
import com.abhijith.ecommerceclone.presentation.home.HomeScreen
import com.abhijith.ecommerceclone.presentation.category.CategoryScreen
import com.abhijith.ecommerceclone.presentation.offers.OffersScreen
import com.abhijith.ecommerceclone.util.Screen

@Composable
fun Navigation(
    navController: NavHostController,
    imageLoader: ImageLoader
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(imageLoader = imageLoader)
        }
        composable(Screen.CategoryScreen.route) {
            CategoryScreen()
        }
        composable(Screen.OffersScreen.route) {
            OffersScreen()
        }
        composable(Screen.CartScreen.route) {
            CartScreen()
        }
        composable(Screen.AccountScreen.route) {
            AccountScreen()
        }
    }
}