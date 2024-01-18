package com.example.dompekid.presentation.dashboard.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.dompekid.adapter.PocketAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.FragmentHomeBinding
import com.example.dompekid.presentation.dashboard.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    private val homeViewModel:HomeViewModel by viewModels()
    override fun inflateBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        observePocketData()
    }

    private fun observePocketData(){
        homeViewModel.updateData()
        homeViewModel.listPocket.observe(viewLifecycleOwner,::setupPocketRV)
    }
    private fun setupPocketRV(list:List<PocketDataResponse?>?){
        binding.componentHomePocketRv.rvPocketHome.adapter=PocketAdapter(list)
    }

}