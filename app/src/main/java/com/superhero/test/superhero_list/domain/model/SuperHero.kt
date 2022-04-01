package com.superhero.test.superhero_list.domain.model

import com.superhero.test.superhero_list.data.remote.response.*
import java.io.Serializable

data class SuperHero(
    val image: String,
    val name: String,
    val powerstats: Powerstats,
    val biography: Biography,
    val appearance: Appearance,
    val work: Work,
    val connections: Connections,
    var isSelected : Boolean = false
) : Serializable

