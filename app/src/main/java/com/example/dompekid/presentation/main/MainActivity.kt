package com.example.dompekid.presentation.main

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.navigation.findNavController
import com.example.dompekid.R
import com.example.dompekid.base.BaseActivity
import com.example.dompekid.databinding.ActivityMainBinding
import com.example.dompekid.presentation.main.dashboard.DashboardFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity:BaseActivity<ActivityMainBinding>() {
    companion object{
        fun navigateToMainActivity(activity: Activity){
            val intent= Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }
    override fun inflateBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun setupView() {

    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        findNavController(binding.navHostFragment.id)
    }

}