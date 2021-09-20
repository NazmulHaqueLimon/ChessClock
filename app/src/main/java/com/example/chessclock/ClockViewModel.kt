package com.example.chessclock

import android.os.CountDownTimer
import androidx.lifecycle.ViewModel

class ClockViewModel : ViewModel() {

    private var startTimeMillis:Long =600000 //10 minits


    private var playerATimeLeft :Long =startTimeMillis
    private var playerBTimeLeft :Long =startTimeMillis

    private val interval:Long =1000

    private var isPlayerARunning: Boolean =false
    private var isPlayerBRunning :Boolean =false

    private var isAnyTimerStop : Boolean =false


    fun setFormat(gameTime:Long,increment:Long){
        startTimeMillis =gameTime
    }


    //private val timer: ChessTimer(startTime,)
    fun startPlayerATimer(){
        if(isPlayerARunning && isAnyTimerStop){
            isAnyTimerStop =false
        }
        playerATimer.start()
    }

    fun startPlayerBTimer(){
        if(isPlayerARunning && isAnyTimerStop){
            isAnyTimerStop =false
        }
        playerBTimer.start()
    }


    fun pauseTimer(){
        playerATimer.cancel()
        playerBTimer.cancel()
    }
    fun updatePlayerATimer(){}
    fun updatePlayerBTimer(){}


    private val playerATimer = object :CountDownTimer(playerATimeLeft,interval ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            playerATimeLeft = millisUntilFinished

        }
        override fun onFinish() {

            isAnyTimerStop =true
        }
    }
    private val playerBTimer = object :CountDownTimer(playerBTimeLeft,interval ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            playerBTimeLeft =millisUntilFinished
        }
        override fun onFinish() {
            isAnyTimerStop =true
        }
    }

}
