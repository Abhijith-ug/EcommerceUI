package com.abhijith.ecommerceclone.di

import android.app.Application
import coil.ImageLoader
import coil.decode.SvgDecoder
import com.abhijith.ecommerceclone.data.remote.HomeApi
import com.abhijith.ecommerceclone.data.repository.HomeRepositoryImpl
import com.abhijith.ecommerceclone.domain.repository.HomeRepository
import com.abhijith.ecommerceclone.domain.usecase.GetHomeDataUseCase
import com.abhijith.ecommerceclone.domain.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideHomeDataApi(client: OkHttpClient): HomeApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HomeApi::class.java)
    }

    @Provides
    @Singleton
    fun provideImageLoader(app: Application): ImageLoader =
        ImageLoader.Builder(app)
            .crossfade(true)
            .crossfade(200)
            .componentRegistry {
                add(SvgDecoder(app))
            }
            .build()

    @Provides
    @Singleton
    fun provideHomeRepository(api: HomeApi):HomeRepository =
        HomeRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetHomeDataUseCase(repository: HomeRepository):GetHomeDataUseCase =
        GetHomeDataUseCase(repository)
}