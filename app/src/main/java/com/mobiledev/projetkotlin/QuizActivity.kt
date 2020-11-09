package com.mobiledev.projetkotlin

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList


class QuizActivity : AppCompatActivity() {

    var quizs = ArrayList<Quiz>()
    var numberOfGoodAnswers: Int = 0
    var currentQuizIndex: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        quizs.add(Quiz("Quelle est la capitale de l'Algérie ?", "Alger", "Paris", "Rome", "Washington",1))
        quizs.add(Quiz("Quelle est la capitale de la France ?", "Alger", "Paris", "Rome", "Washington",2))
        quizs.add(Quiz("Quelle est la capitale de l'Amérique ?", "Alger", "Paris", "Rome", "Washington",4))
        quizs.add(Quiz("Quelle est la capitale de l'Italie ?", "Alger", "Paris", "Rome", "Washington",3))

        shuffle(quizs);

        showQuestion(quizs.get(currentQuizIndex))
    }

    fun showQuestion(quiz: Quiz){
        val question: TextView = findViewById(R.id.Question)
        question.text = quiz.question
        val answ1: TextView = findViewById(R.id.answer1)
        answ1.text = quiz.answer1
        val answ2: TextView = findViewById(R.id.answer2)
        answ2.text = quiz.answer2
        val answ3: TextView = findViewById(R.id.answer3)
        answ3.text = quiz.answer3
        val answ4: TextView = findViewById(R.id.answer4)
        answ4.text = quiz.answer4
    }

    fun handleAnswer(answerID: Int){
        val quiz = quizs.get(currentQuizIndex)

        if (quiz.isCorrect(answerID)){
            numberOfGoodAnswers++
            Toast.makeText(this, "+1", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "+0", Toast.LENGTH_SHORT).show()
        }

        currentQuizIndex++

        if (currentQuizIndex >= quizs.size) {

            val sharedPreferences = getSharedPreferences("com.mobiledev.projetkotlin", Context.MODE_PRIVATE)
            sharedPreferences.edit().putInt("userScore", numberOfGoodAnswers).apply()

            var alert = AlertDialog.Builder(this)
            alert.setTitle("Partie terminé")
            alert.setMessage("Tu as eu : " + numberOfGoodAnswers + " de bonne(s) réponse(s)")
            alert.setPositiveButton("OK") {
                dialogInterface: DialogInterface?, i: Int -> finish()
            }
            alert.show()
        }
        else {
            showQuestion(quizs.get(currentQuizIndex))
        }
    }

    fun onClickAnswerOne(view:View) {
        handleAnswer(1)
    }

    fun onClickAnswerTwo(view:View) {
        handleAnswer(2)
    }

    fun onClickAnswerThree(view:View) {
        handleAnswer(3)
    }

    fun onClickAnswerFour(view:View) {
        handleAnswer(4)
    }
}