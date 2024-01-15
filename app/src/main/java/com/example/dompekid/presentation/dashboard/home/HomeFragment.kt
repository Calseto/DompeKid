package com.example.dompekid.presentation.dashboard.home

import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentHomeBinding

class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    override fun inflateBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupView() {
    }
}