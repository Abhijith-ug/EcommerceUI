package com.abhijith.ecommerceclone.util

sealed class Screen(val route:String){
    object HomeScreen : Screen("home_screen")
    object CategoryScreen : Screen("category_screen")
    object OffersScreen : Screen("offers_screen")
    object CartScreen : Screen("cart_screen")
    object AccountScreen : Screen("account_screen")
}
