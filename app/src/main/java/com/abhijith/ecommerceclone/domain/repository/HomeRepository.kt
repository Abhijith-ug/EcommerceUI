package com.abhijith.ecommerceclone.domain.repository

import com.abhijith.ecommerceclone.domain.models.HomeData
import com.abhijith.ecommerceclone.domain.models.HomeDataX
import com.abhijith.ecommerceclone.domain.util.Resource

interface HomeRepository {
    suspend fun getHomeData(): Resource<List<HomeDataX>>
}