package com.superhero.test.superhero_list.presentation

import com.superhero.test.superhero_list.domain.model.SuperHero

interface OnClickItem {
    fun onClickListener(hero : SuperHero, position: Int)
}