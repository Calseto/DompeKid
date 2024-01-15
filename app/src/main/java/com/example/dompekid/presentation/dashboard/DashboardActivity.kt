package com.example.dompekid.presentation.dashboard

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.dompekid.R
import com.example.dompekid.base.BaseActivity
import com.example.dompekid.databinding.ActivityDashboardBinding
import com.example.dompekid.presentation.dashboard.home.HomeFragment
import com.example.dompekid.presentation.dashboard.learn.LearnFragment
import com.example.dompekid.presentation.dashboard.pocket.PocketFragment
import com.example.dompekid.presentation.dashboard.settings.SettingFragment
import com.example.dompekid.presentation.landing.LandingActivity
import com.example.dompekid.presentation.landing.login.LoginFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlin.properties.Delegates

class DashboardActivity:BaseActivity<ActivityDashboardBinding>() {

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
        binding.bottomNavigation.apply{
            setOnNavigationItemSelectedListener (onNavigationItemSelectedListener)
            selectedItemId=R.id.navigationHome
        }
    }

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId){
                R.id.navigationHome-> {
                    replaceFragment(HomeFragment(),binding.fragmentContainer.id)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationStudy-> {
                    replaceFragment(LearnFragment(),binding.fragmentContainer.id)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigationWallet-> {
                    replaceFragment(PocketFragment(),binding.fragmentContainer.id)
                    return@OnNavigationItemSelectedListener true
                }
                //ganti nama jangan luppa , account -> setting
                R.id.navigationAccount-> {
                    replaceFragment(SettingFragment(),binding.fragmentContainer.id)
                    return@OnNavigationItemSelectedListener true
                }

                else->{return@OnNavigationItemSelectedListener true}
            }
        }

}