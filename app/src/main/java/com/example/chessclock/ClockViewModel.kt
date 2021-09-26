package com.example.chessclock

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClockViewModel: ViewModel() {

    /**
     * selected clock time
     */
     private val _gameTime =MutableLiveData<Long>()
     val gameTime:LiveData<Long> =_gameTime

    /**
     * clock increment for every move
     */
     private val _increment =MutableLiveData<Long>()
     val increment:LiveData<Long> =_increment

    /**
     * playerA left time....converted in binding adapter
     */
    private val _playerATimeLeftMillies  =MutableLiveData<Long>(360000)
    val playerATimeLeftMillies:LiveData<Long> = _playerATimeLeftMillies

    /**
     * playerB left time....converted in binding adapter
     */
    private val _playerBTimeLeftMillies =MutableLiveData<Long>(360000)
    val playerBTimeLeftMillies:LiveData<Long> = _playerBTimeLeftMillies

    /**
     * boolean to define if the match running or not...
     * used for start and pause button to activate or deactivate players timer button
     */
    val _isGameRunning =MutableLiveData<Boolean>(false)
     val isGameRunning:LiveData<Boolean> =_isGameRunning

     private val _isPlayerARunning =MutableLiveData<Boolean>(false)
     val isPlayerARunning:LiveData<Boolean> =_isPlayerARunning

     private val _isPlayerBRunning =MutableLiveData<Boolean>(false)
     val isPlayerBRunning:LiveData<Boolean> =_isPlayerBRunning


     private val _isAnyTimerStop=MutableLiveData<Boolean>(false)
     val isAnyTimerStop:LiveData<Boolean> =_isAnyTimerStop


     private val _playerAMoves =MutableLiveData<Int>(0)
     val playerAMoves :LiveData<Int> =_playerAMoves

     private val _playerBMoves =MutableLiveData<Int>(0)
     val playerBMoves :LiveData<Int> =_playerBMoves


    /**
     * set the selected time format
     */
    fun setFormat(gameTime:Long,increment:Long){
        _gameTime.value =gameTime
        _playerATimeLeftMillies.value =gameTime
        _playerBTimeLeftMillies.value =gameTime
        _increment.value =increment
    }


    fun startPlayerATimer(){

        if(_isPlayerBRunning.value == true){
            _isPlayerBRunning.value =false
            _playerBMoves.value = _playerBMoves.value?.plus(1)
            chessTimerB.cancel()
            //playerBTimer.cancel()
            //and add the increment
            _playerBTimeLeftMillies.value =increment.value?.let {
                _playerBTimeLeftMillies.value?.plus(it)
            }
        }
        //in the beginning simply start the clock
        _isPlayerARunning.value =true
        playerATimeLeftMillies.value?.let { startTimerA(it) }
        //playerATimer.start()

    }
    private lateinit var chessTimerA :CountDownTimer
    private lateinit var chessTimerB :CountDownTimer

    fun startPlayerBTimer(){

        if(_isPlayerARunning.value == true){
            _playerAMoves.value = _playerAMoves.value?.plus(1)
           // playerATimer.cancel()
            _isPlayerARunning.value=false
            chessTimerA.cancel()
            //and add the increment
            _playerATimeLeftMillies.value = increment.value?.let {
                _playerATimeLeftMillies.value?.plus(it)
            }
        }

        //in the beginning simply start the clock
        _isPlayerBRunning.value=true
        playerBTimeLeftMillies.value?.let { startTimerB(it) }
        //playerBTimer.start()
    }

    private fun startTimerA(startTime:Long){
        chessTimerA =object :CountDownTimer(startTime,1000){
            override fun onTick(millisUntilFinished: Long) {
                _playerATimeLeftMillies.value = millisUntilFinished
            }

            override fun onFinish() {
                _isGameRunning.value =false
            }
        }.start()
    }
    private fun startTimerB(startTime:Long){
        chessTimerB =object :CountDownTimer(startTime,1000){
            override fun onTick(millisUntilFinished: Long) {
                _playerBTimeLeftMillies.value = millisUntilFinished
            }

            override fun onFinish() {
                _isGameRunning.value =false

            }
        }.start()
    }


    fun pauseTimer(){
        _isGameRunning.value=false
        _isPlayerARunning.value=false
        //playerATimer.cancel()
        chessTimerA.cancel()
        chessTimerB.cancel()
        _isPlayerBRunning.value=false
       //playerBTimer.cancel()

    }
    fun resetClock(){

        _playerATimeLeftMillies.value =gameTime.value
        _playerBTimeLeftMillies.value =gameTime.value
    }


    /**
    private val playerATimer = object :CountDownTimer(_playerATimeLeftMillies.value?.toLong()!!,1000 ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            _playerATimeLeftMillies.value = millisUntilFinished


        }
        override fun onFinish() {
            _isAnyTimerStop.value =true
        }
    }
    */

    /**
    private val playerBTimer = object :CountDownTimer(playerBTimeLeftMillies.value?.toLong()!!,1000 ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            _playerBTimeLeftMillies.value =millisUntilFinished

        }
        override fun onFinish() {
            _isAnyTimerStop.value =true
        }
    }
     */


}

