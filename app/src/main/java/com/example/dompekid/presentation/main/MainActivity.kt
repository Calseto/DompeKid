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
        setTransparentStatusBar()
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        findNavController(binding.navHostFragment.id)
    }
    private fun setTransparentStatusBar() {
        window.apply {
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            statusBarColor = Color.TRANSPARENT


            decorView.systemUiVisibility =
                decorView.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        }
    }

}