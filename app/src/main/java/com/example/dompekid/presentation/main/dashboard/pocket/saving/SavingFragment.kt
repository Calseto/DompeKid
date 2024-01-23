package com.example.dompekid.presentation.main.dashboard.pocket.saving

import android.view.View
import androidx.fragment.app.viewModels
import com.example.dompekid.adapter.PocketAdapter
import com.example.dompekid.adapter.SavingAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.FragmentSavingBinding
import com.example.dompekid.presentation.main.dashboard.viewmodel.HomeViewModel
import com.example.dompekid.presentation.main.dashboard.viewmodel.SavingFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavingFragment(private val onClick: (PocketDataResponse?)->Unit):BaseFragment<FragmentSavingBinding>() {
    private val viewModel:SavingFragmentViewModel by viewModels()
    override fun inflateBinding(): FragmentSavingBinding {
        return FragmentSavingBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        observePocketData()
    }

    private fun observePocketData(){
        viewModel.updateDataSaving()
        viewModel.listPocketSaving.observe(viewLifecycleOwner,::setupPocketRV)
    }
    private fun setupPocketRV(list:List<PocketDataResponse?>?){
        binding.rvSaving.adapter= SavingAdapter(list,onClick)
    }
}