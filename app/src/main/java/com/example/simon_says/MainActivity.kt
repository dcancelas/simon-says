package com.example.simon_says

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private lateinit var buttons: Array<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.play_button)
        val greenButton: Button = findViewById(R.id.green_button)
        val redButton: Button = findViewById(R.id.red_button)
        val yellowButton: Button = findViewById(R.id.yellow_button)
        val blueButton: Button = findViewById(R.id.blue_button)
        buttons = arrayOf(playButton,greenButton,redButton,yellowButton,blueButton)

        playButton.setOnClickListener {
            for (b in buttons) {
                b.isEnabled = false
            }
            GlobalScope.launch(Dispatchers.IO) {
                startGame()
                /*withContext(Dispatchers.Main) {
                    for (b in buttons) {
                        b.isEnabled = true
                    }
                }*/
            }
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

    private suspend fun startGame() {
        for (x in 1..4) {
            when (x) {
                1 -> {
                    buttons[1].setBackgroundResource(R.drawable.green_pressed_button)
                    delay(1000)
                    buttons[1].setBackgroundResource(R.drawable.green_button)
                }
                2 -> {
                    buttons[2].setBackgroundResource(R.drawable.red_pressed_button)
                    delay(1000)
                    buttons[2].setBackgroundResource(R.drawable.red_button)
                }
                3 -> {
                    buttons[3].setBackgroundResource(R.drawable.yellow_pressed_button)
                    delay(1000)
                    buttons[3].setBackgroundResource(R.drawable.yellow_button)
                }
                4 -> {
                    buttons[4].setBackgroundResource(R.drawable.blue_pressed_button)
                    delay(1000)
                    buttons[4].setBackgroundResource(R.drawable.blue_button)
                }
            }
        }
    }
}