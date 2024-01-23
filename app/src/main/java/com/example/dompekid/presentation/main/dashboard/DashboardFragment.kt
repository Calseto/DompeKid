package com.example.dompekid.presentation.main.dashboard

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.activityViewModels
import com.example.dompekid.R
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentDasboardBinding
import com.example.dompekid.model.MenuItem
import com.example.dompekid.model.MenuStatus
import com.example.dompekid.presentation.main.dashboard.home.HomeFragment
import com.example.dompekid.presentation.main.dashboard.learn.LearnFragment
import com.example.dompekid.presentation.main.dashboard.pocket.PocketFragment
import com.example.dompekid.presentation.main.dashboard.settings.SettingFragment
import com.example.dompekid.utils.BottomNavManager
import dagger.hilt.android.AndroidEntryPoint


//bis di optimasi , klo sempet ganti
@AndroidEntryPoint
class DashboardFragment:BaseFragment<FragmentDasboardBinding>() {
    private val viewModel:DashboardViewModel by activityViewModels<DashboardViewModel>()
    private lateinit var bottomNavManager:BottomNavManager

    override fun inflateBinding(): FragmentDasboardBinding {
        return FragmentDasboardBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupBottomNavMenu()

    }

    private fun setupBottomNavMenu (){
        bottomNavManager= BottomNavManager(preparedMenuItemList())
        viewModel.btmNavPOs.observe(requireActivity()){
            bottomNavManager.changeMenu(it)
            manageFragmentTransition(it)
        }
        binding.customBottomNav.apply {
            btmNavHomeIcon.setOnClickListener{
                val menuID=0
                viewModel.updateBtmNavPos(menuID)
            }
            btmNavLearnIcon.setOnClickListener{
                val menuID=1
                viewModel.updateBtmNavPos(menuID)

            }
            btmNavPocketIcon.setOnClickListener{
                val menuID=2
                viewModel.updateBtmNavPos(menuID)

            }
            btmNavSettingsIcon.setOnClickListener{
                val menuID=3
                viewModel.updateBtmNavPos(menuID)

            }
        }
    }
    private fun preparedMenuItemList():List<MenuItem> {
        return listOf(
            MenuItem(
                0, binding.customBottomNav.btmNavHomeIcon, binding.customBottomNav.btmNavHomeText,
                R.drawable.icon_home_selected, R.drawable.icon_home, MenuStatus.SELECTED
            ),
            MenuItem(
                1, binding.customBottomNav.btmNavLearnIcon, binding.customBottomNav.btmNavLearnText,
                R.drawable.icon_book_selected, R.drawable.icon_book, MenuStatus.DESELECTED
            ),
            MenuItem(
                2, binding.customBottomNav.btmNavPocketIcon, binding.customBottomNav.btmNavPocketText,
                R.drawable.icon_pocket_selected, R.drawable.icon_pocket, MenuStatus.DESELECTED
            ),
            MenuItem(
                3, binding.customBottomNav.btmNavSettingsIcon, binding.customBottomNav.btmNavSettingsText,
                R.drawable.icon_profile_selected, R.drawable.icon_profile, MenuStatus.DESELECTED
            )
        )
    }

    private fun manageFragmentTransition(menuID:Int){
        val transaction=requireActivity().supportFragmentManager.beginTransaction()
        when (menuID) {
            0 -> transaction.replace(binding.fragmentContainer.id, HomeFragment())
            1 -> transaction.replace(binding.fragmentContainer.id, LearnFragment())
            2 -> transaction.replace(binding.fragmentContainer.id, PocketFragment())
            3 -> transaction.replace(binding.fragmentContainer.id, SettingFragment())
        }
        transaction.commit()
    }

}