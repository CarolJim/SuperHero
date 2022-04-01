package com.superhero.test.superhero_list.data.repository

import com.superhero.test.superhero_list.data.remote.response.SuperHeroDto
import retrofit2.http.GET

interface SuperHeroApi {

    @GET("character-id")
    suspend fun getAllCharacterId(): SuperHeroDto
}