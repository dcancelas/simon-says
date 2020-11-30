package com.example.simon_says

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.random.Random

class MyViewModel : ViewModel() {

    var bDisabled = MutableLiveData<Boolean>()
    var bState = MutableLiveData<Int>()
    var button = 0

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

    fun startGame() {
        CoroutineScope(Dispatchers.Main).launch {
            button = 5
            bDisabled.value = true
            for (x in 1..4) {
                button = x
                bDisabled.value = true
                bState.value = 2
            }
            for (x in 1..5) {
                val b = Random.nextInt(1,4)
                button = b
                bState.value = 1
                delay(500)
                button = b
                bState.value = 2
                delay(500)
            }
            for (x in 1..4) {
                button = x
                bDisabled.value = false
                bState.value = 0
            }
            button = 5
            bDisabled.value = false
        }
    }
}