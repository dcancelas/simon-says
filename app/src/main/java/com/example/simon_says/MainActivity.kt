package com.example.simon_says

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val greenButton: Button = findViewById(R.id.green_button)
        greenButton.setOnClickListener {
            Toast.makeText(this, "green is selected", Toast.LENGTH_SHORT).show()
        }
        val redButton: Button = findViewById(R.id.red_button)
        redButton.setOnClickListener {
            Toast.makeText(this, "red is selected", Toast.LENGTH_SHORT).show()
        }
        val yellowButton: Button = findViewById(R.id.yellow_button)
        yellowButton.setOnClickListener {
            Toast.makeText(this, "yellow is selected", Toast.LENGTH_SHORT).show()
        }
        val blueButton: Button = findViewById(R.id.blue_button)
        blueButton.setOnClickListener {
            Toast.makeText(this, "blue is selected", Toast.LENGTH_SHORT).show()
        }
    }
}