package com.superhero.test.superhero_list.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.superhero.test.common.setImage
import com.superhero.test.superhero_list.domain.model.SuperHero
import test.R
import test.databinding.LayoutHeroListItemBinding

class SuperHeroListAdapter(
    private var superHeroList: ArrayList<SuperHero>,
    private var onClickItem: OnClickItem
    ) : RecyclerView.Adapter<SuperHeroListAdapter.SuperHeroListDataBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroListDataBinding =
        SuperHeroListDataBinding(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_hero_list_item, parent, false)
        )

    override fun onBindViewHolder(holder: SuperHeroListDataBinding, position: Int) {
        holder.binding.apply {
            val hero = superHeroList[position]
            superHeroImage.setImage(hero.image)
            superHeroNameText.text = hero.name
            holder.itemView.setOnClickListener { updateHeroSelected(position) }

        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateHeroSelected(position: Int) {
        for (hero in superHeroList){
            hero.isSelected = hero.name == superHeroList[position].name
        }
        onClickItem.onClickListener(superHeroList[position],position)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = superHeroList.size

    class SuperHeroListDataBinding(view: View) : RecyclerView.ViewHolder(view) {
        val binding = LayoutHeroListItemBinding.bind(view)
    }

}