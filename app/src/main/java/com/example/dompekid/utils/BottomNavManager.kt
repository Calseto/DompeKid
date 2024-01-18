package com.example.dompekid.utils

import android.animation.ObjectAnimator
import android.view.View
import android.widget.ImageView
import com.example.dompekid.R
import com.example.dompekid.model.MenuItem

class BottomNavManager(private val menuList:List<MenuItem>){
    fun changeMenu(selectedItem:Int){
        for (menu in menuList){
            if(menu.id==selectedItem) {
                startBottomIconAnimOnSelect(menu)
            }
            else{
                startBottomIconAnimOnDeselect(menu)
            }
        }
    }
    private fun startBottomIconAnimOnSelect(menuItem: MenuItem){
        val duration:Long=100 //dalam millis
        menuItem.apply {
            icon.apply {
                setImageResource(selectedIcon)
                animateMove("translationY", -20f, duration)
            }
            text.apply {
                animateMove("translationY", -20f, duration-50)
                animateFade("in", duration)
            }
        }
    }
    private fun startBottomIconAnimOnDeselect(menuItem: MenuItem){
        val duration:Long=100 //dalam millis
        menuItem.apply {
            icon.apply {
                setImageResource(deselectedIcon)
                animateMove("translationY", 0f, duration)
            }
            text.apply {
                animateMove("translationY", 0f, duration-50)
                animateFade("out", duration)
            }
        }
    }
    private fun View.animateMove(direction:String, distance:Float, transTime:Long){
        ObjectAnimator.ofFloat(this, direction, distance).apply {
            duration = transTime
            start()
        }
    }
    private fun View.animateFade(inOut:String, delay:Long){
        this.postDelayed({
            // Set the visibility to VISIBLE with a smooth fade-in animation
            when(inOut){
                "in"->{
                    this.visibility = View.VISIBLE
                    this.animate().alpha(1f).duration = delay
                }
                "out"->{
                    this.animate().alpha(0f).duration = delay
                }
            }
        }, delay)
    }
}