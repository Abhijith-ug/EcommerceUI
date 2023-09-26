package com.abhijith.ecommerceclone.domain.usecase

import com.abhijith.ecommerceclone.domain.models.HomeDataX
import com.abhijith.ecommerceclone.domain.repository.HomeRepository
import com.abhijith.ecommerceclone.domain.util.Resource

class GetHomeDataUseCase(
    private val repository: HomeRepository
) {

    suspend operator fun invoke(): Resource<List<HomeDataX>> =
        repository.getHomeData()
}