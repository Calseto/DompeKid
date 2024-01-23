package com.example.dompekid.presentation.main.transfer

import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.dompekid.R
import com.example.dompekid.adapter.PocketTabAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.databinding.FragmentChooseFundSourceBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChoosePocketPaymentFragment:BaseFragment<FragmentChooseFundSourceBinding>() {
    override fun inflateBinding(): FragmentChooseFundSourceBinding {
        return FragmentChooseFundSourceBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupTabLayout()
    }


    private fun setupTabLayout(){
        val viewPager: ViewPager2 = binding.componenRVFundSourceChoice.viewPagerWallet
        val tabLayout: TabLayout = binding.componenRVFundSourceChoice.tabNavWallet
        val adapter = PocketTabAdapter(requireActivity()){
            if (it?.status==true) {
                val bundle = bundleOf("pocket" to it)
                val action =
                    ChoosePocketPaymentFragmentDirections.actionChoosePocketPaymentFragmentToTransferFragmentA().actionId
                findNavController().navigate(action, bundle)
            }else{
                makeToast("Pocket Tidak Memenuhi Syarat")
            }
        }
        viewPager.adapter = adapter

        // Connect TabLayout with ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when (position) {
                0 -> tab.text="Tabungan"
                1 -> tab.text="Uang Saku"
            }
        }.attach()
        setTabListener(tabLayout)
    }
    private fun setTabListener(tabLayout: TabLayout){
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val position = tab.position
                when (position) {
                    0 -> tabLayout.setBackgroundResource(R.drawable.tab_layout_saving_selected)
                    1 -> tabLayout.setBackgroundResource(R.drawable.tab_layout_allowance_selected)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }
}