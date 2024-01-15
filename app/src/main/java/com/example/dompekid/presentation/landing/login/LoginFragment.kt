package com.example.dompekid.presentation.landing.login

import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentLoginBinding

class LoginFragment:BaseFragment<FragmentLoginBinding>(){
    private var onClickLogin:()->Unit={}
    override fun inflateBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        handleGoToHome()
    }
    fun setLoginNavDes(navFun:()->Unit){
        onClickLogin=navFun
    }
    private fun handleGoToHome(){
        binding.btnLogin.setOnClickListener{
            onClickLogin.invoke()
        }
    }

}