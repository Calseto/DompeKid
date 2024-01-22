package com.example.dompekid.presentation.landing.login

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.LoginRequest
import com.example.dompekid.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment(private val viewModel:LoginViewModel):BaseFragment<FragmentLoginBinding>(){
    private var onClickLogin:()->Unit={}
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
            if(it!="gagal"&&it!=null){
                viewModel.saveTokenToSharedPref()
                onClickLogin.invoke()
            }
            else if(it=="gagal"){
                makeToast("Username atau password yang anda masukan salah")
            }
        }
    }
    private fun setupLoadingProgress(){
//        viewModel.loadingState.observe(viewLifecycleOwner){loading->
//            if(loading){
//                Glide.with(this)
//                    .asGif()
//                    .load(R.drawable.your_gif_resource) // Replace with your actual GIF resource
//                    .into(imageView)
//            }else{
//
//            }
//        }
    }

}