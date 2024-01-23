package com.example.dompekid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.presentation.main.dashboard.pocket.allowance.AllowanceFragment
import com.example.dompekid.presentation.main.dashboard.pocket.saving.SavingFragment

class PocketTabAdapter (fragmentActivity: FragmentActivity,private val onClick: (PocketDataResponse?)->Unit) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SavingFragment(onClick)
            1 -> AllowanceFragment(onClick)
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}