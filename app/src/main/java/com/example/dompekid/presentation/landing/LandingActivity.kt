package com.example.dompekid.presentation.landing

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import android.view.View
import androidx.fragment.app.FragmentManager
import com.example.dompekid.base.BaseActivity
import com.example.dompekid.databinding.ActivityLandingBinding
import com.example.dompekid.presentation.dashboard.DashboardActivity
import com.example.dompekid.presentation.landing.login.LoginFragment


class LandingActivity : BaseActivity<ActivityLandingBinding>() {

    private val loginFragment=LoginFragment()
    companion object{
        fun navigateToLandingTransaction(activity: Activity){
            val intent= Intent(activity, LandingActivity::class.java)
            activity.startActivity(intent)
        }
    }


    override fun inflateBinding(): ActivityLandingBinding {
        return ActivityLandingBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        setTransparentStatusBar()

        setupLoginFragment()

        handleLogin()
    }

    override fun onBackPressed(){
        try {
            if (supportFragmentManager.backStackEntryCount>0)
                closeLoginFragment()
            else super.onBackPressed()

        }catch (e:Exception){
            super.onBackPressed()
        }
    }

    private fun setupLoginFragment(){
        loginFragment.setLoginNavDes{
            DashboardActivity.navigateToDashboardActivity(this)
        }
    }
    private fun handleLogin(){
        binding.btnLoginLanding.setOnClickListener{
            openLoginFragment()
        }
    }
    private fun openLoginFragment() {
        binding.fragmentContainer.setVisible(View.VISIBLE)
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.fade_out)
            replace(binding.fragmentContainer.id, loginFragment)
            addToBackStack("fragmentLogin")
            commit()
        }
    }

    private fun closeLoginFragment(){
        supportFragmentManager.popBackStack(
            "fragmentLogin",
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        Handler().postDelayed({
            binding.fragmentContainer.setVisible(View.GONE)
        },500)
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