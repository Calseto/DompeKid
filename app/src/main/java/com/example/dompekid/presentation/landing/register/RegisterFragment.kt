package com.example.dompekid.presentation.landing.register


import com.example.dompekid.base.BaseFragment
import com.example.dompekid.data.youngsaverapi.responsemodel.CreateAccountRequest
import com.example.dompekid.data.youngsaverapi.responsemodel.RegisRequest
import com.example.dompekid.databinding.FragmentRegisterBinding
import dagger.hilt.android.AndroidEntryPoint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

@AndroidEntryPoint
class RegisterFragment(private val viewModel: RegisterViewModel) :
    BaseFragment<FragmentRegisterBinding>() {
    private var onClickLogin: () -> Unit = {}
    override fun inflateBinding(): FragmentRegisterBinding {
        return FragmentRegisterBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        handleLoginAttempt()
        handleLogin()
    }

    fun setLoginNavDes(navFun: () -> Unit) {
        onClickLogin = navFun
    }

    private fun register() {
        val email = binding.componentEmailLogin.edttxtEmailLogin.text.toString()
        val pass = binding.componentPassLogin.edttxtPassLogin.text.toString()
        val name = binding.fragmentFillData.edttxtName.text.toString()
        val dob = binding.fragmentFillData.edttxtDOB.text.toString()
        val phone = binding.fragmentFillData.edttxtPhoneNumber.text.toString()
        val address = binding.fragmentFillData.edttxtAddress.text.toString()
        val createAcc = CreateAccountRequest(email, pass)
        val regisRequest = RegisRequest(name, address, phone,dob)
        viewModel.register(regisRequest, createAcc)
    }

    private fun handleLoginAttempt() {
        binding.btnRegister.setOnClickListener {
            register()
        }
    }

    private fun handleLogin() {
        viewModel.status.observe(viewLifecycleOwner) {
            if (it == true) {
                activity?.onBackPressed()
                makeToast("Registrasi Berhasil")
                viewModel.resetLiveData()
            } else if (it == false) {
                makeToast("registrasi gagal")
            }
        }
    }

    private fun setupLoadingProgress() {
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