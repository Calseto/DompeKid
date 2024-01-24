package com.example.dompekid.presentation.main.dashboard.home

import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.dompekid.R
import com.example.dompekid.adapter.PocketAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.data.youngsaverapi.responsemodel.UserRespons
import com.example.dompekid.databinding.FragmentHomeBinding
import com.example.dompekid.presentation.main.dashboard.DashboardFragmentDirections
import com.example.dompekid.presentation.main.dashboard.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment:BaseFragment<FragmentHomeBinding>() {
    private val homeViewModel: HomeViewModel by viewModels()
    private var listPocket:List<PocketDataResponse?>?= listOf()
    override fun inflateBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        observeViewModel()
        setupBtnToTransfer()
        handleLoadingState()
    }

    private fun handleLoadingState(){
        homeViewModel.loadingState.observe(viewLifecycleOwner){
            if (it==true){
                openLoadingFragment(binding.progressbar)
            }
            else{
                closeLoadingFragment(binding.progressbar)
            }
        }
    }

    private fun setupBtnToTransfer(){
        binding.btnToTransferPage.setOnClickListener{
            val action=DashboardFragmentDirections.actionDashboardFragmentToChoosePocketPaymentFragment()
            findNavController().navigate(action)
        }
    }


    private fun observeViewModel(){
        homeViewModel.updateDataHome()
        homeViewModel.listPocket.observe(viewLifecycleOwner,::setupPocketRV)
        homeViewModel.userData.observe(viewLifecycleOwner,::setupUserData)
    }
    private fun setupUserData(userRespons: UserRespons?){
        homeViewModel.turnOffLoadingState()
        binding.componentHomeTop.apply {
            tvNameHome.text=userRespons?.data?.get(0)?.name
            tvCurrentBalanceHome.text="Rp "+ userRespons?.data?.get(0)?.showedBalance.toString()

            var saving:Long?=0
            var allowance:Long?=0
            if(listPocket!=null) {
                for (pocket in listPocket!!) {
                    if (pocket?.jenisPocket=="Tabungan") saving=pocket.saldo
                    if (pocket?.jenisPocket=="UangSaku") allowance=pocket.saldo
                }
            }
            tvCurrentAllowanceHome.text=allowance.toString()
            tvCurrentSavingHome.text=saving.toString()
        }
    }
    private fun setupPocketRV(list:List<PocketDataResponse?>?){
        listPocket=list
        binding.componentHomePocketRv.rvPocketHome.adapter=PocketAdapter(list){
            val bundle = bundleOf("pocket" to it)
            findNavController().navigate(R.id.action_dashboardFragment_to_topUpPocketFragment,bundle)
        }

    }

}