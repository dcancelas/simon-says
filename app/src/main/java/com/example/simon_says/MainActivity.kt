package com.example.simon_says

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var buttons: Array<Button>
    private var running: Boolean = false
    private var score: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val s: TextView = findViewById(R.id.score)
        s.text = score.toString()
        val bs: TextView = findViewById(R.id.best_score)
        bs.text = score.toString()
        val playButton: Button = findViewById(R.id.play_button)
        val greenButton: Button = findViewById(R.id.green_button)
        val redButton: Button = findViewById(R.id.red_button)
        val yellowButton: Button = findViewById(R.id.yellow_button)
        val blueButton: Button = findViewById(R.id.blue_button)
        buttons = arrayOf(playButton,greenButton,redButton,yellowButton,blueButton)

        playButton.setOnClickListener {
            if (!running) startGame()
            else {

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

    private fun startGame() {
        GlobalScope.launch {
            running = true
            for (x in 1..4) {
                setButton(x,"unpressed")
            }
            for (x in 1..4) {
                setButton(x,"pressed")
                delay(1000)
                setButton(x,"unpressed")
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
                if (state == "default") buttons[1].setBackgroundResource(R.drawable.green_button)
                if (state == "pressed") buttons[1].setBackgroundResource(R.drawable.green_pressed_button)
                if (state == "unpressed") buttons[1].setBackgroundResource(R.drawable.green_unpressed_button)
            }
            2 -> {
                if (state == "default") buttons[2].setBackgroundResource(R.drawable.red_button)
                if (state == "pressed") buttons[2].setBackgroundResource(R.drawable.red_pressed_button)
                if (state == "unpressed") buttons[2].setBackgroundResource(R.drawable.red_unpressed_button)
            }
            3 -> {
                if (state == "default") buttons[3].setBackgroundResource(R.drawable.yellow_button)
                if (state == "pressed") buttons[3].setBackgroundResource(R.drawable.yellow_pressed_button)
                if (state == "unpressed") buttons[3].setBackgroundResource(R.drawable.yellow_unpressed_button)
            }
            4 -> {
                if (state == "default") buttons[4].setBackgroundResource(R.drawable.blue_button)
                if (state == "pressed") buttons[4].setBackgroundResource(R.drawable.blue_pressed_button)
                if (state == "unpressed") buttons[4].setBackgroundResource(R.drawable.blue_unpressed_button)
            }
        }
    }
}