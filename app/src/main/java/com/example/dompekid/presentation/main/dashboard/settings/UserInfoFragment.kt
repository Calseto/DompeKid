package com.example.dompekid.presentation.main.dashboard.settings

import androidx.fragment.app.viewModels
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentUserInfoBinding
import com.example.dompekid.presentation.main.dashboard.viewmodel.UserInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserInfoFragment:BaseFragment<FragmentUserInfoBinding>() {

    private val viewModel:UserInfoViewModel by viewModels()
    override fun inflateBinding(): FragmentUserInfoBinding {
        return FragmentUserInfoBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        getData()
        handleData()
    }

    private fun handleData(){
        viewModel.userData.observe(viewLifecycleOwner){
            if(it?.data != null) {
                binding.textViewName.text = it.data[0]?.name
                binding.textViewAddress.text = it.data[0]?.address
                binding.textViewDob.text = it.data[0]?.birthDate
                binding.textViewPhone.text = it.data[0]?.phoneNumber
            }
        }
    }

    private fun getData(){
        viewModel.updateData()
    }
}