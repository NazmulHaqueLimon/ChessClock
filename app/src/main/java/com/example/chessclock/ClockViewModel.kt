package com.example.chessclock

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClockViewModel : ViewModel() {

    /**
     * selected clock time
     */
    private val startTimeMillis =MutableLiveData<Long>(600000)

    /**
     * clock increment for every move
     */
    private val _increment =MutableLiveData<Long>(0)
    private val increment:LiveData<Long> =_increment

    /**
     * playerA left time....converted in binding adapter
     */
    private val _playerATimeLeftMillies =startTimeMillis
    val playerATimeLeftMillies:LiveData<Long> = _playerATimeLeftMillies

    /**
     * playerB left time....converted in binding adapter
     */
    private val _playerBTimeLeftMillies =startTimeMillis
    val playerBTimeLeftMillies:LiveData<Long> = _playerBTimeLeftMillies


    var isPlayerARunning: Boolean =false
    var isPlayerBRunning :Boolean =false

    var isAnyTimerStop : Boolean =false

    private val _playerAMoves =MutableLiveData<Int>(0)
    val playerAMoves :LiveData<Int> =_playerAMoves

    private val _playerBMoves =MutableLiveData<Int>(0)
    val playerBMoves :LiveData<Int> =_playerBMoves


    /**
     * set the selected time format
     */
    fun setFormat(gameTime:Long,increment:Long){
        startTimeMillis.value =gameTime
        _increment.value =increment
    }


    fun startPlayerATimer(){
        if(isPlayerBRunning){
            isPlayerBRunning =false
            playerBTimer.cancel()
        }
        else{
            isPlayerARunning =true
            playerATimer.start()
        }
    }

    fun startPlayerBTimer(){
        if(isPlayerARunning ){
            playerATimer.cancel()
        }
        isPlayerBRunning=true
        playerBTimer.start()
    }


    fun pauseTimer(){
        playerATimer.cancel()
        playerBTimer.cancel()
    }
    fun resetClock(){

    }


    private val playerATimer = object :CountDownTimer(playerATimeLeftMillies.value?.toLong()!!,1000 ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            _playerATimeLeftMillies.value = millisUntilFinished
            _playerAMoves.value = _playerAMoves.value?.plus(1)

        }
        override fun onFinish() {

            isAnyTimerStop =true
        }
    }

    private val playerBTimer = object :CountDownTimer(playerBTimeLeftMillies.value?.toLong()!!,1000 ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            _playerBTimeLeftMillies.value =millisUntilFinished
            _playerBMoves.value = _playerBMoves.value?.plus(1)
        }
        override fun onFinish() {
            isAnyTimerStop =true
        }
    }

}
