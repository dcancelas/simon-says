package com.example.simon_says

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.random.Random

class MyViewModel : ViewModel() {

    var bDisabled = MutableLiveData<Int>()
    var bEnabled = MutableLiveData<Int>()
    var bState = mutableListOf<Int>()
    var bStateLiveData = MutableLiveData<MutableList<Int>>()

    init {
        bStateLiveData.value = bState
    }

    /*
    Botones
    1 -> greenButton
    2 -> redButton
    3 -> yellowButton
    4 -> blueButton
    5 -> playButton
    Estados
    0 -> default
    1 -> pressed
    2 -> unpressed
    */

    private fun startGame() {
        CoroutineScope(Dispatchers.Main).launch {
            bDisabled.value = 5
            for (x in 1..4) {
                //setButton(x,"unpressed")
                bDisabled.value = x
                bState[0] = x
                bState[1] = 2
            }
            for (x in 1..5) {
                val b = Random.nextInt(1,4)
                //setButton(b,"pressed")
                bState[0] = b
                bState[1] = 1
                delay(500)
                //setButton(b,"unpressed")
                bState[0] = b
                bState[1] = 2
                delay(500)
            }
            for (x in 1..4) {
                //setButton(x,"default")
                bEnabled.value = x
                bState[0] = x
                bState[1] = 0
            }
            bEnabled.value = 5
        }
    }
    fun test() {
        CoroutineScope(Dispatchers.Main).launch {
            bDisabled.value = 5
            for (x in 1..5) {
                val b = Random.nextInt(1,4)
                bDisabled.value = b
                delay(500)
                bEnabled.value = b
                delay(500)
            }
            bEnabled.value = 5
        }
    }
}