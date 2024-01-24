package com.example.dompekid.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dompekid.data.youngsaverapi.responsemodel.PocketDataResponse
import com.example.dompekid.presentation.main.dashboard.pocket.allowance.AllowanceFragment
import com.example.dompekid.presentation.main.dashboard.pocket.saving.SavingFragment
import com.example.dompekid.presentation.main.dashboard.viewmodel.AllowanceFragmentViewModel
import com.example.dompekid.presentation.main.dashboard.viewmodel.SavingFragmentViewModel

class PocketTabAdapter (
    fragmentActivity: FragmentActivity, private val onClick: (PocketDataResponse?)->Unit,
    private val viewModelSaving: SavingFragmentViewModel,
    private val viewModelAllowance: AllowanceFragmentViewModel
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SavingFragment(onClick,viewModelSaving)
            1 -> AllowanceFragment(onClick,viewModelAllowance)
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}