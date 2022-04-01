package com.superhero.test.superhero_list.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import test.R
import test.databinding.FragmentOnErrorBinding


class OnErrorFragment : Fragment() {

    private lateinit var binding: FragmentOnErrorBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentOnErrorBinding.inflate(inflater,container,false)
        return binding.root
    }

}