package com.example.dompekid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dompekid.presentation.main.dashboard.pocket.allowance.AllowanceFragment
import com.example.dompekid.presentation.main.dashboard.pocket.saving.SavingFragment

class PocketTabAdapter (fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SavingFragment()
            1 -> AllowanceFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}