package com.abhijith.ecommerceclone.presentation.ui

import com.abhijith.ecommerceclone.domain.models.HomeDataX
import com.abhijith.ecommerceclone.domain.models.Value

data class HomeState(
    val categoryData: List<Value> = emptyList(),
    val bannerData: List<Value> = emptyList(),
    val productData: List<Value> = emptyList(),
    val isLoading:Boolean = false
)
