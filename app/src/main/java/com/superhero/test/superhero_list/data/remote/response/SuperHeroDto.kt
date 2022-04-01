package com.superhero.test.superhero_list.data.remote.response

import com.superhero.test.superhero_list.domain.model.SuperHero

data class SuperHeroDto(
    val appearance: Appearance,
    val biography: Biography,
    val connections: Connections,
    val id: String,
    val image: String,
    val name: String,
    val powerstats: Powerstats,
    val response: String,
    val work: Work
)

fun SuperHeroDto.toSuperHeroList() : ArrayList<SuperHero> = arrayListOf(SuperHero(
    appearance = appearance,
    biography = biography,
    connections = connections,
    image = image,
    name = name,
    powerstats = powerstats,
    work = work
))