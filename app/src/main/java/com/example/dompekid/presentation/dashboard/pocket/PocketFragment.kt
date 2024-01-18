package com.example.dompekid.presentation.dashboard.pocket

import androidx.viewpager2.widget.ViewPager2
import com.example.dompekid.adapter.PocketTabAdapter
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentPocketBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class PocketFragment:BaseFragment<FragmentPocketBinding>() {
    override fun inflateBinding(): FragmentPocketBinding {
        return FragmentPocketBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        val viewPager: ViewPager2 = binding.componentWalletBottom.viewPagerWallet
        val tabLayout: TabLayout = binding.componentWalletBottom.tabNavWallet
        val adapter = PocketTabAdapter(requireActivity())
        viewPager.adapter = adapter

        // Connect TabLayout with ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Notifications"
                1 -> "Status Transaksi"
                else -> null
            }
        }.attach()
    }
}