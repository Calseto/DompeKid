package com.example.dompekid.base

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.dompekid.R

abstract class BaseActivity<T:ViewBinding>:AppCompatActivity() {
    protected lateinit var binding:T

     abstract fun inflateBinding():T
     abstract fun setupView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=inflateBinding()
        setContentView(binding.root)
        setupView()
    }

    protected fun replaceFragment(fragment: Fragment,viewId:Int){
        supportFragmentManager.beginTransaction()
            .replace(viewId,fragment)
            .commit()
    }

    protected fun View.setVisible(visibility:Int)
    {
        if(visibility==View.VISIBLE||visibility==View.INVISIBLE||visibility==View.GONE){
            this.visibility=visibility
        }else{
            throw IllegalArgumentException("the given interger parameter should be the value of either View.VISIBLE, View.INVISIBLE, or View.GONE")
        }
    }
}