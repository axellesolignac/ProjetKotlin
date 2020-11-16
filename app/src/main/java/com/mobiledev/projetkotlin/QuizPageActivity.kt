package com.mobiledev.projetkotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

/*Configuration des "clicks" sur les deux boutons du menu de quiz*/

class QuizPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_page)
    }

    fun onClickBtnPlay(view: View){
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
    }

    fun onClickBtnScore(view: View){
        val intent = Intent(this, ScoreActivity::class.java)
        startActivity(intent)
    }
}