package com.abhijith.ecommerceclone.data.repository

import com.abhijith.ecommerceclone.data.remote.HomeApi
import com.abhijith.ecommerceclone.domain.models.HomeData
import com.abhijith.ecommerceclone.domain.models.HomeDataX
import com.abhijith.ecommerceclone.domain.repository.HomeRepository
import com.abhijith.ecommerceclone.domain.util.Resource
import retrofit2.HttpException
import java.io.IOException

class HomeRepositoryImpl(
    private val api: HomeApi
):HomeRepository {

    override suspend fun getHomeData(): Resource<List<HomeDataX>> {
        return try {
            val response = api.getHomeData()
            if (response.status) {
                Resource.Success(data = response.homeData)
            }else {
                Resource.Error("Something went wrong!")
            }
        } catch (e: IOException) {
            Resource.Error("Could'nt reach server. Pleace check your internet connection.")
        } catch (e: HttpException) {
            Resource.Error("Something went wrong!")
        }
    }
}