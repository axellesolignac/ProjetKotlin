package com.mobiledev.projetkotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/*Persistance des données avec le score du quiz*/

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)
    }

    override fun onResume() {
        super.onResume()

        val sharedPreferences = getSharedPreferences("com.mobiledev.projetkotlin", Context.MODE_PRIVATE)
        val userScore = sharedPreferences.getInt("userScore", -1)
        if (userScore > -1) {
            val score: TextView = findViewById(R.id.txt_score)
            score.text = "Ton dernier score est de $userScore"
        }
    }
}