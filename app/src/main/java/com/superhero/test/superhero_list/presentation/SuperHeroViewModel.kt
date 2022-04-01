package com.superhero.test.superhero_list.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.superhero.test.common.Resource
import com.superhero.test.superhero_list.domain.model.SuperHero
import com.superhero.test.superhero_list.domain.model.SuperHeroState
import com.superhero.test.superhero_list.domain.use_case.GetSuperHeroListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SuperHeroViewModel @Inject constructor(
    private val getSuperHeroListUseCase: GetSuperHeroListUseCase
) : ViewModel() {

    private val _getSuperHeroState = MutableLiveData<SuperHeroState>()
    val getSuperHeroState: LiveData<SuperHeroState> get() = _getSuperHeroState

    init {
        getSuperHeroList()
    }

    private fun getSuperHeroList() {
        getSuperHeroListUseCase.invoke().onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _getSuperHeroState.value = SuperHeroState(isLoading = true)
                }
                is Resource.Success -> {
                    _getSuperHeroState.value = SuperHeroState(response = result.data)
                }
                is Resource.Error -> {
                    _getSuperHeroState.value = SuperHeroState(error = result.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }

}