package com.superhero.test.superhero_list.data.repository

import com.superhero.test.superhero_list.data.remote.response.SuperHeroDto
import com.superhero.test.superhero_list.data.repository.SuperHeroApi
import com.superhero.test.superhero_list.domain.repository.SuperHeroRepository
import javax.inject.Inject

class SuperHeroRepositoryImpl @Inject constructor(private val api : SuperHeroApi):
    SuperHeroRepository {

    override suspend fun getAllSuperHero(): SuperHeroDto = api.getAllCharacterId()
}