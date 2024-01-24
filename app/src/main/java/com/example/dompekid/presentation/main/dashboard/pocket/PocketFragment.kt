package com.example.dompekid.presentation.main.dashboard.pocket

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.dompekid.R
import com.example.dompekid.adapter.PocketTabAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentPocketBinding
import com.example.dompekid.presentation.main.dashboard.DashboardFragmentDirections
import com.example.dompekid.presentation.main.dashboard.viewmodel.AllowanceFragmentViewModel
import com.example.dompekid.presentation.main.dashboard.viewmodel.SavingFragmentViewModel
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PocketFragment:BaseFragment<FragmentPocketBinding>() {

    private val viewModelSaving: SavingFragmentViewModel by viewModels()
    private val viewModelAllowance: AllowanceFragmentViewModel by viewModels()
    override fun inflateBinding(): FragmentPocketBinding {
        return FragmentPocketBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupTabLayout()
        setupFloatingButtonDestination()
    }

    private fun setupFloatingButtonDestination(){
        binding.ivFLoatingBtn.setOnClickListener{
            val action = DashboardFragmentDirections.actionDashboardFragmentToCreatePocketFragment()
            findNavController().navigate(action)
        }
    }

    private fun setupTabLayout(){
        val viewPager: ViewPager2 = binding.componentWalletBottom.viewPagerWallet
        val tabLayout: TabLayout = binding.componentWalletBottom.tabNavWallet
        val adapter = PocketTabAdapter(requireActivity(),{},viewModelSaving,viewModelAllowance)
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
    private fun setTabListener(tabLayout:TabLayout){
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