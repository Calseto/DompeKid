package com.example.dompekid.model

import java.text.NumberFormat
import java.util.Locale

data class PocketModel (
    val title:String,
    var balance : Int,
    val type:Int,
    var target: Int?
){
    fun balanceToString():String{
        return "Rp "+formatNumber(balance)
    }
    private fun formatNumber(number: Int): String {
        val numberFormat = NumberFormat.getNumberInstance(Locale.getDefault())
        return numberFormat.format(number)
    }
}

enum class PocketType(val value: Int){
    Saving(1),
    Allowance(0)
}