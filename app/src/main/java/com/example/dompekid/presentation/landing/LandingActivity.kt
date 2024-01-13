package com.example.dompekid.presentation.landing

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.FragmentManager
import com.example.dompekid.databinding.ActivityLandingBinding
import com.example.dompekid.presentation.landing.login.LoginFragment
import kotlin.concurrent.thread

class LandingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLandingBinding
    private var fragmentManager = supportFragmentManager
    companion object{
        fun navigateToDetailTransaction(activity: Activity){
            val intent= Intent(activity, LandingActivity::class.java)
            activity.startActivity(intent)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLandingBinding.inflate(layoutInflater)
        val view=binding.root

        setContentView(view)
        setTransparentStatusBar()


        handleLogin()
    }

    override fun onBackPressed(){
        try {
            if (fragmentManager.backStackEntryCount > 0) {
                closeLoginFragment()
            } else {
                super.onBackPressed()
            }
        }catch (e:Exception){
            super.onBackPressed()
        }
    }

    private fun closeLoginFragment(){
        fragmentManager.popBackStack(
            "fragmentLogin",
            FragmentManager.POP_BACK_STACK_INCLUSIVE
        )
        Handler().postDelayed({
            binding.fragmentContainer.setVisible(false)
        },1000)
    }

    private fun handleLogin(){
        binding.btnLoginLanding.setOnClickListener{
            openLoginFragment()
        }
    }
    private fun openLoginFragment() {
        binding.fragmentContainer.setVisible(true)
        fragmentManager.beginTransaction().apply {
            setCustomAnimations(android.R.anim.fade_in,android.R.anim.fade_out,android.R.anim.fade_in,android.R.anim.fade_out)
            replace(binding.fragmentContainer.id, LoginFragment())
            addToBackStack("fragmentLogin")
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

    private fun View.setVisible(boolean: Boolean)
    {
        if(boolean){
            this.visibility=View.VISIBLE
        }else{
            this.visibility=View.GONE
        }
    }

}