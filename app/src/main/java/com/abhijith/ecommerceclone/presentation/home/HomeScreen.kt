package com.abhijith.ecommerceclone.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.ImageLoader
import com.abhijith.ecommerceclone.R
import com.abhijith.ecommerceclone.presentation.HomeScreenViewModel
import com.abhijith.ecommerceclone.presentation.components.CategoryItem
import com.abhijith.ecommerceclone.presentation.components.ProductItem
import com.abhijith.ecommerceclone.presentation.components.StandardTextField
import com.abhijith.ecommerceclone.util.SpaceLarge
import com.abhijith.ecommerceclone.util.SpaceMedium
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(
    onNavigate: () -> Unit = {},
    imageLoader: ImageLoader,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.homeState.value
    LazyColumn{
        item {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = SpaceMedium),
            ) {
                Spacer(modifier = Modifier.height(SpaceLarge))

                // Search Bar
                StandardTextField(
                    modifier = Modifier.padding(SpaceMedium),
                    basicTextFieldModifier = Modifier
                        .fillMaxWidth()
                        .height(42.dp),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    },
                    trailingIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_qrcode),
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                            )
                        }
                    },
                    hint = stringResource(R.string.search),
                    value = "",
                    onValueChange = {

                    }
                )

                // Categories
                LazyRow(
                    contentPadding = PaddingValues(SpaceMedium),
                    horizontalArrangement = Arrangement.spacedBy(SpaceMedium),
                    content = {
                        items(state.categoryData) {
                            CategoryItem(item = it, imageLoader = imageLoader)
                        }
                    }
                )

                // Banner
                AutoSlidingCarousal(
                    banners = state.bannerData,
                    imageLoader = imageLoader
                )

                // Products
                LazyRow(
                    contentPadding = PaddingValues(SpaceMedium),
                    horizontalArrangement = Arrangement.spacedBy(SpaceMedium),
                    content = {
                        items(state.productData) {
                            ProductItem(
                                product = it,
                                imageLoader = imageLoader
                            )
                        }
                    }
                )
            }
        }
    }
}