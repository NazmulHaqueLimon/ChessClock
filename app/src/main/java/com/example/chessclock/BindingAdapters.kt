package com.example.chessclock

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import java.util.*


@BindingAdapter("app:displayTimer")
fun displayTimer(view: TextView,timeInMillis:Long){
    val minutes:Int =((timeInMillis/1000)/60).toInt()
    val seconds:Int =((timeInMillis/1000)%60).toInt()
    val time:String = String.format(
        Locale.getDefault(),
        "%02d:%02d",minutes,seconds)
    view.text =time

}