package com.example.dompekid.presentation.landing.login

import androidx.fragment.app.viewModels
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment:BaseFragment<FragmentLoginBinding>(){
    private var onClickLogin:()->Unit={}
    private val viewModel:LoginViewModel by viewModels()
    override fun inflateBinding(): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        handleLoginAttempt()
        handleLogin()
    }
    fun setLoginNavDes(navFun:()->Unit){
        onClickLogin=navFun
    }
    private fun fetchToken(){
        val email = binding.componentEmailLogin.edttxtEmailLogin.text.toString()
        val pass = binding.componentPassLogin.edttxtPassLogin.text.toString()
        val loginRequest=LoginRequest(email,pass)
        viewModel.fetchToken(loginRequest)
    }
    private fun handleLoginAttempt(){
        binding.btnLogin.setOnClickListener{
            fetchToken()
        }
    }
    private fun handleLogin(){
        viewModel.JWTToken.observe(viewLifecycleOwner){
            if(it!=null){
                viewModel.saveTokenToSharedPref()
                onClickLogin.invoke()
            }
            else{
                makeToast("Username atau password yang anda masukan salah")
            }
        }
    }

}