package com.example.dompekid.presentation.landing.filldetail

import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentEditUserDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FillDetailFragment:BaseFragment<FragmentEditUserDataBinding>() {
    override fun inflateBinding(): FragmentEditUserDataBinding {
        return FragmentEditUserDataBinding.inflate(layoutInflater)
    }
    override fun setupView() {

    }
}