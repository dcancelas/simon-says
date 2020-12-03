package com.example.simon_says

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import kotlin.random.Random

class MyViewModel : ViewModel() {

    val bDisabled = MutableLiveData<Boolean>()
    val bState = MutableLiveData<Int>()
    var button = 0
    //Variables del juego
    var running = MutableLiveData<Boolean>()
    private var sequence = mutableListOf<Int>()
    private var compSequence = mutableListOf<Int>()
    private var seqPosition = 0
    val bestScore = MutableLiveData<Int>()
    val score = MutableLiveData<Int>()

    init {
        running.value
        bestScore.value = 0
        score.value = 0
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

    fun startGame() {
        score.value = 0
        sequence = emptyList<Int>().toMutableList()
        running.value = true

        button = 5
        bDisabled.value = true

        startSequence(500)
    }

    fun endGame() {
        button = 5
        bDisabled.value = false

        if (score.value!! > bestScore.value!!) bestScore.value = score.value
        score.value = 0
    }

    private fun startSequence(delayTime: Long) {
        CoroutineScope(Dispatchers.Main).launch {
            compSequence = emptyList<Int>().toMutableList()
            seqPosition = 0

            sequence.add(Random.nextInt(1,4))

            for (x in 1..4) {
                button = x
                bDisabled.value = true
                bState.value = 2
            }

            for (x in sequence) {
                button = x
                delay(delayTime)
                bState.value = 1
                delay(delayTime)
                bState.value = 2
            }

            for (x in 1..4) {
                button = x
                bDisabled.value = false
                bState.value = 0
            }
        }
    }

    fun compareSequences(button: Int) {
        compSequence.add(button)
        if (button == sequence[seqPosition]) {
            seqPosition++
            if (compSequence == sequence) {
                score.value = score.value?.plus(1)
                startSequence(500)
            }
        }
        else {
            running.value = false
        }
    }
}