package com.abhijith.ecommerceclone.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavOptions
import androidx.navigation.navOptions
import com.abhijith.ecommerceclone.R
import com.abhijith.ecommerceclone.domain.models.BottomNavItem
import com.abhijith.ecommerceclone.util.Screen
import com.abhijith.ecommerceclone.util.SpaceLarge

@Composable
fun StandardBottomBar(
    onNavigate: (route: String, navOptions: NavOptions) -> Unit,
    navBackStackEntry: NavBackStackEntry?
) {
    val context = LocalContext.current
    val bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem(
            route = Screen.HomeScreen.route,
            icon = painterResource(id = R.drawable.ic_home),
            contentDescription = stringResource(R.string.home)
        ),
        BottomNavItem(
            route = Screen.CategoryScreen.route,
            icon = painterResource(id = R.drawable.ic_categories),
            contentDescription = stringResource(R.string.categories)
        ),
        BottomNavItem(
            route = Screen.OffersScreen.route,
            icon = painterResource(id = R.drawable.ic_offers),
            contentDescription = stringResource(R.string.offers)
        ),
        BottomNavItem(
            route = Screen.CartScreen.route,
            icon = painterResource(id = R.drawable.ic_cart),
            contentDescription = stringResource(R.string.cart)
        ),
        BottomNavItem(
            route = Screen.AccountScreen.route,
            icon = painterResource(id = R.drawable.ic_account),
            contentDescription = stringResource(R.string.account)
        )
    )
    val selectedItem = remember { mutableStateOf(0) }
    val routeName = navBackStackEntry?.destination?.route

    NavigationBar(
        modifier = Modifier
            .shadow(elevation = SpaceLarge),
        containerColor = MaterialTheme.colorScheme.background
    ) {
        bottomNavItems.forEachIndexed { index, item ->
            val isSelected = routeName == item.route
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.background,
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurface
                ),
                selected = isSelected,
                onClick = {
                    selectedItem.value = index
                    onNavigate(item.route, navOptions {
                        popUpTo(Screen.HomeScreen.route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    })
                },
                label = {
                    Text(text = item.contentDescription)
                },
                icon = {
                    Column {
                        Icon(
                            painter = item.icon,
                            modifier = Modifier.size(SpaceLarge),
                            contentDescription = item.contentDescription
                        )
                    }
                }
            )
        }
    }
}