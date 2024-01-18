package com.example.dompekid.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView

data class MenuItem(
    val id: Int,
    val icon: ImageView,
    val text: View,
    val selectedIcon: Int,
    val deselectedIcon: Int,
    val status: MenuStatus
);

enum class MenuStatus() {
    SELECTED,
    DESELECTED
}
