package com.example.simon_says

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

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
    private var running: Boolean = false
    private var bestScore: Int = 0
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        playButton.setOnClickListener {
            if (!running) startGame()
            else {}
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

    private fun startGame() {
        GlobalScope.launch {
            running = true
            for (x in 1..4) {
                setButton(x,"unpressed")
            }

            for (x in 1..5) {
                val b = Random.nextInt(1,4)
                setButton(b,"pressed")
                delay(500)
                setButton(b,"unpressed")
                delay(500)
            }

            for (x in 1..4) {
                setButton(x,"default")
            }

            running = false
        }
    }

    private fun setButton(button: Int, state: String) {
        when (button) {
            1 -> {
                if (state == "default") greenButton.setBackgroundResource(R.drawable.green_button)
                if (state == "pressed") greenButton.setBackgroundResource(R.drawable.green_pressed_button)
                if (state == "unpressed") greenButton.setBackgroundResource(R.drawable.green_unpressed_button)
            }
            2 -> {
                if (state == "default") redButton.setBackgroundResource(R.drawable.red_button)
                if (state == "pressed") redButton.setBackgroundResource(R.drawable.red_pressed_button)
                if (state == "unpressed") redButton.setBackgroundResource(R.drawable.red_unpressed_button)
            }
            3 -> {
                if (state == "default") yellowButton.setBackgroundResource(R.drawable.yellow_button)
                if (state == "pressed") yellowButton.setBackgroundResource(R.drawable.yellow_pressed_button)
                if (state == "unpressed") yellowButton.setBackgroundResource(R.drawable.yellow_unpressed_button)
            }
            4 -> {
                if (state == "default") blueButton.setBackgroundResource(R.drawable.blue_button)
                if (state == "pressed") blueButton.setBackgroundResource(R.drawable.blue_pressed_button)
                if (state == "unpressed") blueButton.setBackgroundResource(R.drawable.blue_unpressed_button)
            }
        }
    }
}