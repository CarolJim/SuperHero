package com.superhero.test.di

import com.superhero.test.common.Constants
import com.superhero.test.superhero_list.data.repository.SuperHeroApi
import com.superhero.test.superhero_list.data.repository.SuperHeroRepositoryImpl
import com.superhero.test.superhero_list.domain.repository.SuperHeroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesHeroApi(): SuperHeroApi =
        Retrofit.Builder().baseUrl(Constants.SUPERHERO_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SuperHeroApi::class.java)

    @Provides
    @Singleton
    fun providesHeroListRepository(api: SuperHeroApi): SuperHeroRepository =
        SuperHeroRepositoryImpl(api)

}