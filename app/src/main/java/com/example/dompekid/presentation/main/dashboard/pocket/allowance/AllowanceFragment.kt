package com.example.dompekid.presentation.main.dashboard.pocket.allowance

import androidx.fragment.app.viewModels
import com.example.dompekid.adapter.AllowanceAdapter
import com.example.dompekid.adapter.SavingAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.FragmentAllowanceBinding
import com.example.dompekid.databinding.FragmentSavingBinding
import com.example.dompekid.presentation.main.dashboard.viewmodel.AllowanceFragmentViewModel
import com.example.dompekid.presentation.main.dashboard.viewmodel.SavingFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllowanceFragment:BaseFragment<FragmentAllowanceBinding>() {
    private val viewModel: AllowanceFragmentViewModel by viewModels()
    override fun inflateBinding(): FragmentAllowanceBinding {
        return FragmentAllowanceBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        observePocketData()
    }

    private fun observePocketData(){
        viewModel.updateDataAllowance()
        viewModel.listPocketAllowance.observe(viewLifecycleOwner,::setupPocketRV)
    }
    private fun setupPocketRV(list:List<PocketDataResponse?>?){
        binding.rvAllowance.adapter= AllowanceAdapter(list)
    }
}