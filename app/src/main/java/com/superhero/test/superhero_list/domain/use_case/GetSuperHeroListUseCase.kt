package com.superhero.test.superhero_list.domain.use_case

import com.superhero.test.common.Resource
import com.superhero.test.superhero_list.data.remote.response.toSuperHeroList
import com.superhero.test.superhero_list.domain.model.SuperHero
import com.superhero.test.superhero_list.domain.repository.SuperHeroRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSuperHeroListUseCase @Inject constructor(
    private val repository: SuperHeroRepository
) {

    operator fun invoke(): Flow<Resource<ArrayList<SuperHero>>> = flow {
        try {
            emit(Resource.Loading())
            val superHeroList = repository.getAllSuperHero().toSuperHeroList()
            emit(Resource.Success(superHeroList))
        } catch (e: Exception) {
            emit(Resource.Error(Throwable(e.localizedMessage ?: "")))
        }
    }

}