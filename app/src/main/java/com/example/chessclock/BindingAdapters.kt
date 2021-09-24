package com.example.chessclock


import android.view.View
import android.widget.ImageView
import android.widget.TextView
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

@BindingAdapter("app:startButtonVisibility")
fun startButtonVisibility(view: ImageView,isGameRunning:Boolean){
    if (isGameRunning){
        view.visibility = View.INVISIBLE;
    }
    else{
        view.visibility =View.VISIBLE
    }
}
@BindingAdapter("app:pauseButtonVisibility")
fun pauseButtonVisibility(view: ImageView,isGameRunning:Boolean){
    if (isGameRunning){
        view.visibility = View.VISIBLE;
    }
    else{
        view.visibility =View.INVISIBLE
    }
}