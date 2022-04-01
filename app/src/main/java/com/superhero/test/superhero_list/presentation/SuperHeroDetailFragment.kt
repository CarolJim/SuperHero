package com.superhero.test.superhero_list.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import test.R
import test.databinding.FragmentSuperHeroDetailBinding

@AndroidEntryPoint
class SuperHeroDetailFragment : DialogFragment() {

    private lateinit var binding : FragmentSuperHeroDetailBinding
    private val args : SuperHeroDetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentSuperHeroDetailBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initButton()
        setInformationHero()
    }

    private fun setInformationHero() {
        binding.apply {
            biography.nameText.text = args.superHeroArg.biography.fullName



        }
    }

    private fun initButton() {
        binding.closeImage.setOnClickListener {
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()
        isCancelable = false
    }


}