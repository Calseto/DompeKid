package com.example.dompekid.utils

import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.dompekid.R
import com.example.dompekid.base.BaseFragment
import com.example.dompekid.databinding.FragmentLoadingBinding

class LoadingPageFragment:BaseFragment<FragmentLoadingBinding>() {
    override fun inflateBinding(): FragmentLoadingBinding {
        return FragmentLoadingBinding.inflate(layoutInflater)
    }

    override fun setupView() {
        Glide.with(this)
            .asGif()  // Specify that the resource is a GIF
            .load(R.drawable.finish)  // Replace 'your_gif_filename' with the actual name of your GIF file (without the extension)
            .into(binding.loadingImage);
    }

}