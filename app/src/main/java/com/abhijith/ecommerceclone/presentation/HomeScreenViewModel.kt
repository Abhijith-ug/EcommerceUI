package com.abhijith.ecommerceclone.presentation

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.abhijith.ecommerceclone.domain.models.Value
import com.abhijith.ecommerceclone.domain.usecase.GetHomeDataUseCase
import com.abhijith.ecommerceclone.domain.util.Resource
import com.abhijith.ecommerceclone.presentation.ui.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : ViewModel() {

    private val _searchQuery = mutableStateOf(TextFieldValue())
    val searchQuery: State<TextFieldValue> = _searchQuery

    private val _homeState = mutableStateOf(HomeState())
    val homeState: State<HomeState> = _homeState

    init {
        getHomeData()
    }

    private fun getHomeData() {
        viewModelScope.launch {
            when (val result = getHomeDataUseCase()) {
                is Resource.Error -> {

                }

                is Resource.Loading -> {
                    _homeState.value = _homeState.value.copy(isLoading = true)
                }

                is Resource.Success -> {
                    val (categoryData, bannerData, productData) = result.data.orEmpty()
                        .groupBy { it.type }
                        .values
                        .map { it.map { value -> value.values } }

                    _homeState.value = _homeState.value.copy(
                        categoryData = categoryData.flatten(),
                        bannerData = bannerData.flatten(),
                        productData = productData.flatten()
                    )
                }
            }
        }
    }
}