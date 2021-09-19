package com.example.chessclock

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClockViewModel : ViewModel() {

    private val _startTime =MutableLiveData<Int>()
    val startTime:LiveData<Int> = _startTime

    private var isRunning: Boolean =false
    private val isTimerStop : Boolean =false

    private val timer=CountDownTimer

    fun startTimer(){
        if(isRunning && isTimerStop){
            isRunning =false
        }
    }
    fun pauseTimer(){}
    fun updateTime(){}

}
