package com.abhijith.ecommerceclone.data.remote

import com.abhijith.ecommerceclone.domain.models.HomeData
import retrofit2.Response
import retrofit2.http.GET

interface HomeApi {

    @GET("v3/69ad3ec2-f663-453c-868b-513402e515f0/")
    suspend fun getHomeData(): HomeData
}