package com.example.dompekid.presentation.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.dompekid.R
import com.example.dompekid.base.BaseActivity
import com.example.dompekid.databinding.ActivityDashboardBinding
import com.example.dompekid.model.MenuItem
import com.example.dompekid.model.MenuStatus
import com.example.dompekid.presentation.dashboard.home.HomeFragment
import com.example.dompekid.presentation.dashboard.learn.LearnFragment
import com.example.dompekid.presentation.dashboard.pocket.PocketFragment
import com.example.dompekid.presentation.dashboard.settings.SettingFragment
import com.example.dompekid.presentation.landing.LandingActivity
import com.example.dompekid.presentation.landing.login.LoginFragment
import com.example.dompekid.utils.BottomNavManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class DashboardActivity:BaseActivity<ActivityDashboardBinding>() {
    private lateinit var bottomNavManager:BottomNavManager
    companion object{
        fun navigateToDashboardActivity(activity: Activity){
            val intent= Intent(activity, DashboardActivity::class.java)
            activity.startActivity(intent)
        }
    }

    override fun inflateBinding(): ActivityDashboardBinding {
        return ActivityDashboardBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setupBottomNavMenu()

    }

    private fun setupBottomNavMenu (){
        bottomNavManager= BottomNavManager(preparedMenuItemList())
        bottomNavManager.changeMenu(0)
        manageFragmentTransition(0)
        binding.customBottomNav.apply {
            btmNavHomeIcon.setOnClickListener{
                val menuID=0
                bottomNavManager.changeMenu(menuID)
                manageFragmentTransition(menuID)
            }
            btmNavLearnIcon.setOnClickListener{
                val menuID=1
                bottomNavManager.changeMenu(menuID)
                manageFragmentTransition(menuID)
            }
            btmNavPocketIcon.setOnClickListener{
                val menuID=2
                bottomNavManager.changeMenu(menuID)
                manageFragmentTransition(menuID)
            }
            btmNavSettingsIcon.setOnClickListener{
                val menuID=3
                bottomNavManager.changeMenu(menuID)
                manageFragmentTransition(menuID)
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
            when (menuID) {
                0 -> {
                    replaceFragment(HomeFragment(), binding.fragmentContainer.id)
                }
                1 -> {
                    replaceFragment(LearnFragment(), binding.fragmentContainer.id)
                }
                2 -> {
                    replaceFragment(PocketFragment(), binding.fragmentContainer.id)
                }
                3 -> {
                    replaceFragment(SettingFragment(), binding.fragmentContainer.id)
                }
            }
        }

}