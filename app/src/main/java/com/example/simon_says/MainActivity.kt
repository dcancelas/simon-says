package com.example.simon_says

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    //Variables de tipo TextView
    lateinit var outputText: TextView
    lateinit var bScoreTextView: TextView
    lateinit var scoreTextView: TextView
    //Variables de tipo Button
    lateinit var playButton: Button
    lateinit var greenButton: Button
    lateinit var redButton: Button
    lateinit var yellowButton: Button
    lateinit var blueButton: Button
    //Variables del juego
    private var bestScore: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myViewModel by viewModels<MyViewModel>()

        bScoreTextView = findViewById(R.id.best_score)
        bScoreTextView.text = bestScore.toString()
        scoreTextView = findViewById(R.id.score)
        scoreTextView.text = score.toString()
        outputText = findViewById(R.id.output_text)

        playButton = findViewById(R.id.play_button)
        greenButton = findViewById(R.id.green_button)
        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        blueButton = findViewById(R.id.blue_button)

        myViewModel.bDisabled.observe(this, Observer {
            button -> disableButton(button)
        })
        myViewModel.bEnabled.observe(this, Observer {
            button -> enableButton(button)
        })
        myViewModel.bStateLiveData.observe(this, Observer {
            bState -> setButton(bState[0], bState[1])
        })

        playButton.setOnClickListener {
            //startGame()
            myViewModel.test()
        }
        greenButton.setOnClickListener {

        }
        redButton.setOnClickListener {

        }
        yellowButton.setOnClickListener {

        }
        blueButton.setOnClickListener {

        }
    }

    private fun disableButton(button: Int) {
        when (button) {
            1 -> {
                greenButton.isEnabled = false
            }
            2 -> {
                redButton.isEnabled = false
            }
            3 -> {
                yellowButton.isEnabled = false
            }
            4 -> {
                blueButton.isEnabled = false
            }
            5 -> {
                playButton.isEnabled = false
            }
        }
    }

    private fun enableButton(button: Int) {
        when (button) {
            1 -> {
                greenButton.isEnabled = true
            }
            2 -> {
                redButton.isEnabled = true
            }
            3 -> {
                yellowButton.isEnabled = true
            }
            4 -> {
                blueButton.isEnabled = true
            }
            5 -> {
                playButton.isEnabled = true
            }
        }
    }

    private fun setButton(button: Int, state: Int) {
        when (button) {
            1 -> {
                if (state == 0) greenButton.setBackgroundResource(R.drawable.green_button)
                if (state == 1) greenButton.setBackgroundResource(R.drawable.green_pressed_button)
                if (state == 2) greenButton.setBackgroundResource(R.drawable.green_unpressed_button)
            }
            2 -> {
                if (state == 0) redButton.setBackgroundResource(R.drawable.red_button)
                if (state == 1) redButton.setBackgroundResource(R.drawable.red_pressed_button)
                if (state == 2) redButton.setBackgroundResource(R.drawable.red_unpressed_button)
            }
            3 -> {
                if (state == 0) yellowButton.setBackgroundResource(R.drawable.yellow_button)
                if (state == 1) yellowButton.setBackgroundResource(R.drawable.yellow_pressed_button)
                if (state == 2) yellowButton.setBackgroundResource(R.drawable.yellow_unpressed_button)
            }
            4 -> {
                if (state == 0) blueButton.setBackgroundResource(R.drawable.blue_button)
                if (state == 1) blueButton.setBackgroundResource(R.drawable.blue_pressed_button)
                if (state == 2) blueButton.setBackgroundResource(R.drawable.blue_unpressed_button)
            }
        }
    }
}