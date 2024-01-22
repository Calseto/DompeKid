package com.example.dompekid.presentation.landing

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import com.example.dompekid.base.BaseActivity
import com.example.dompekid.databinding.ActivityLandingBinding
import com.example.dompekid.presentation.main.dashboard.DashboardFragment
import com.example.dompekid.presentation.landing.login.LoginFragment
import com.example.dompekid.presentation.landing.login.LoginViewModel
import com.example.dompekid.presentation.landing.register.RegisterFragment
import com.example.dompekid.presentation.landing.register.RegisterViewModel
import com.example.dompekid.presentation.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity : BaseActivity<ActivityLandingBinding>() {

    private val viewModel: LoginViewModel by viewModels()
    private val viewModelRegis: RegisterViewModel by viewModels()
    private lateinit var loginFragment:LoginFragment
    private lateinit var regisFragment:RegisterFragment

    companion object{

        const val FRAGMENT_REGIS = "fragmentRegis"
        const val FRAGMENT_LOGIN = "fragmentLogin"

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
        setupFragment()
        handleLogin()
        handleRegis()
    }

    override fun onBackPressed(){
        try {
            val totalFragment = supportFragmentManager.backStackEntryCount
            if (totalFragment>0) {
                val lastFragmentEntry = supportFragmentManager.getBackStackEntryAt(totalFragment - 1)
                val name=lastFragmentEntry.name
                closeFragmentWindow(name)
            }
            else super.onBackPressed()

        }catch (e:Exception){
            super.onBackPressed()
        }
    }

    private fun setupFragment(){
        loginFragment=LoginFragment(viewModel)
        regisFragment=RegisterFragment(viewModelRegis)
    }

    private fun setupLoginFragmentNav(){
        loginFragment.setLoginNavDes{
            MainActivity.navigateToMainActivity(this)
            finish()
        }
    }
    private fun handleRegis(){
        binding.btnRegisterLanding.setOnClickListener{
            openFragmentWindow(FRAGMENT_REGIS)
        }
    }
    private fun handleLogin(){
        setupLoginFragmentNav()
        binding.btnLoginLanding.setOnClickListener{
            openFragmentWindow(FRAGMENT_LOGIN)
        }
    }
    private fun openFragmentWindow(name:String) {
        binding.fragmentContainerLandingActivity.visibility=View.VISIBLE
        setupFragmentTransaction(name)
    }

    private fun closeFragmentWindow(fragmentName:String?){
        supportFragmentManager.popBackStack(
            fragmentName,
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        viewModel.resetLiveData()
        Handler().postDelayed({
            binding.fragmentContainerLandingActivity.visibility=View.GONE
        },500)
    }

    private fun setupFragmentTransaction(name:String){
        supportFragmentManager.beginTransaction().apply {
            setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
            )
            when(name){
                FRAGMENT_REGIS-> replace(binding.fragmentContainerLandingActivity.id, regisFragment)
                FRAGMENT_LOGIN-> replace(binding.fragmentContainerLandingActivity.id, loginFragment)
            }
            addToBackStack(name)
            commit()
        }
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