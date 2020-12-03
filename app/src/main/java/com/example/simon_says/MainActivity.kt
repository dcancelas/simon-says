package com.example.simon_says

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myViewModel by viewModels<MyViewModel>()

        bScoreTextView = findViewById(R.id.best_score)
        bScoreTextView.text = myViewModel.bestScore.value.toString()
        scoreTextView = findViewById(R.id.score)
        scoreTextView.text = myViewModel.score.value.toString()
        outputText = findViewById(R.id.output_text)

        playButton = findViewById(R.id.play_button)
        greenButton = findViewById(R.id.green_button)
        redButton = findViewById(R.id.red_button)
        yellowButton = findViewById(R.id.yellow_button)
        blueButton = findViewById(R.id.blue_button)

        myViewModel.running.observe(this, Observer { running ->
            run {
                if (!running) {
                    myViewModel.endGame()
                    endGameDialog()
                }
            }
        })
        myViewModel.bestScore.observe(this, Observer { bestScore ->
            bScoreTextView.text = bestScore.toString()
        })
        myViewModel.score.observe(this, Observer { score ->
            scoreTextView.text = score.toString()
        })
        myViewModel.bDisabled.observe(this, Observer { disabled ->
            run {
                if (disabled) disableButton(myViewModel.button)
                else enableButton(myViewModel.button)
            }
        })
        myViewModel.bState.observe(this, Observer { bState ->
            setButtonState(myViewModel.button, bState)
        })

        playButton.setOnClickListener {
            myViewModel.startGame()
        }
        greenButton.setOnClickListener {
            if (myViewModel.running.value == true)
                myViewModel.compareSequences(1)
        }
        redButton.setOnClickListener {
            if (myViewModel.running.value == true)
                myViewModel.compareSequences(2)
        }
        yellowButton.setOnClickListener {
            if (myViewModel.running.value == true)
                myViewModel.compareSequences(3)
        }
        blueButton.setOnClickListener {
            if (myViewModel.running.value == true)
                myViewModel.compareSequences(4)
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

    private fun setButtonState(button: Int, state: Int) {
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

    private fun endGameDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.game_over)
        builder.setPositiveButton(R.string.ok, null)
        val dialog = builder.create().show()
    }
}