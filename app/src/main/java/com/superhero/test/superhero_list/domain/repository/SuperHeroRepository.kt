package com.superhero.test.superhero_list.domain.repository

import com.superhero.test.superhero_list.data.remote.response.SuperHeroDto

interface SuperHeroRepository {

    suspend fun getAllSuperHero() : SuperHeroDto


}