package com.example.dompekid.presentation.main.dashboard.settings

import android.graphics.Color
import androidx.navigation.fragment.findNavController
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentSettingsBinding
import com.example.dompekid.presentation.landing.LandingActivity
import com.example.dompekid.presentation.main.dashboard.DashboardFragmentDirections

class SettingFragment : BaseFragment<FragmentSettingsBinding>() {
    override fun inflateBinding(): FragmentSettingsBinding {
        return FragmentSettingsBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        binding.apply {
            componentSetAcc.apply {
                btnNameSettings.apply {
                    tvItemSettings.text = "User Detail"
                    tvItemSettings.setOnClickListener{
                            val action=DashboardFragmentDirections.actionDashboardFragmentToUserInfoFragment()
                            findNavController().navigate(action)
                        }
                }
            }
            componentSetLog.apply {
                btnLogoutSettings.apply {
                    tvItemSettings.apply {
                        text = "Log Out"
                        setTextColor(Color.RED)
                    }
                    tvItemSettings.setOnClickListener {
                        LandingActivity.navigateToLandingTransaction(requireActivity())
                        activity?.finish()
                    }
                }
            }
        }
    }

}