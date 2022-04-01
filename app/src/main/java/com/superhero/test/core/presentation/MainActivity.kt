package com.superhero.test.core.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import dagger.hilt.android.AndroidEntryPoint
import test.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewBinding(layoutInflater)
    }

    private fun initViewBinding(inflater: LayoutInflater) {
        binding = ActivityMainBinding.inflate(inflater)
        setContentView(binding.root)
    }
}