package com.example.skuska2.domain.model

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.ui.graphics.painter.Painter

data class Engine(
    val id:Int,
    val typeOfEngine: String,
    val description: String,
    val image: Int,
)
