package com.superhero.test.superhero_list.domain.model

data class SuperHeroState(
    val isLoading: Boolean = false,
    val response: ArrayList<SuperHero>? = arrayListOf(),
    val error: String = ""
)