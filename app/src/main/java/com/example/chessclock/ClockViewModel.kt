package com.example.chessclock

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClockViewModel : ViewModel() {

    /**
     * selected clock time
     */
    private val _gameTime =MutableLiveData<Long>()
    private val gameTime:LiveData<Long> =_gameTime

    /**
     * clock increment for every move
     */
    private val _increment =MutableLiveData<Long>()
    private val increment:LiveData<Long> =_increment

    /**
     * playerA left time....converted in binding adapter
     */
    private val _playerATimeLeftMillies =MutableLiveData<Long>()
    val playerATimeLeftMillies:LiveData<Long> = _playerATimeLeftMillies

    /**
     * playerB left time....converted in binding adapter
     */
    private val _playerBTimeLeftMillies =MutableLiveData<Long>()
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
        _playerBMoves.value = _playerBMoves.value?.plus(1)
        if(_isPlayerBRunning.value == true){
            //stop 2nd clock
            _isPlayerBRunning.value =false
            playerBTimer.cancel()
            //and add the increment
            _playerBTimeLeftMillies.value =increment.value?.let {
                _playerBTimeLeftMillies.value?.plus(it)
            }
            //then start the first one
            _isPlayerARunning.value=true
            playerATimer.start()
        }
        else{
            //in the beginning simply start the clock
            _isPlayerARunning.value =true
            playerATimer.start()
        }
    }

    fun startPlayerBTimer(){
        _playerAMoves.value = _playerAMoves.value?.plus(1)
        if(_isPlayerARunning.value == true){
            //stop the first clock
            playerATimer.cancel()
            _isPlayerARunning.value=false
            //and add the increment
            _playerATimeLeftMillies.value = increment.value?.let {
                _playerATimeLeftMillies.value?.plus(
                    it
                )
            }

            //then start the 2nd one
            _isPlayerBRunning.value=true
            playerBTimer.start()
        }
        else{
            //in the beginning simply start the clock
            _isPlayerBRunning.value=true
            playerBTimer.start()
        }

    }


    fun pauseTimer(){
        _isPlayerARunning.value=false
        playerATimer.cancel()
        _isPlayerBRunning.value=false
        playerBTimer.cancel()

    }
    fun resetClock(){

        _playerATimeLeftMillies.value =_gameTime.value
        _playerBTimeLeftMillies.value =_gameTime.value
    }


    private val playerATimer = object :CountDownTimer(playerATimeLeftMillies.value!!,1000 ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            _playerATimeLeftMillies.value = millisUntilFinished


        }
        override fun onFinish() {
            _isAnyTimerStop.value =true
        }
    }

    private val playerBTimer = object :CountDownTimer(playerBTimeLeftMillies.value!!,1000 ) {
        override fun onTick(millisUntilFinished: Long) {
            //every 1000th millisecond the timer updates
            _playerBTimeLeftMillies.value =millisUntilFinished

        }
        override fun onFinish() {
            _isAnyTimerStop.value =true
        }
    }

}
