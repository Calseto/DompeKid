package com.example.dompekid.presentation.main.dashboard.pocket.allowance

import android.view.View
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
class AllowanceFragment(
    private val onClick: (PocketDataResponse?)->Unit,
    private val viewModel: AllowanceFragmentViewModel
):BaseFragment<FragmentAllowanceBinding>() {
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
    private fun setupPocketRV(list:List<PocketDataResponse?>?) {
        binding.rvAllowance.adapter = AllowanceAdapter(list,onClick)
    }
}