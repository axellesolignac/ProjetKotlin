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

        quizs.add(Quiz("Quel célèbre dictateur dirigea l’URSS du milieu des années 1920 à 1953 ?", "Molotov", "Trotski", "Staline", "Lénine",3))
        quizs.add(Quiz("Qui a dit : « Le sort en est jeté » (Alea jacta est) ?", "Vercingétorix", "César", "Attila", "Auguste",2))
        quizs.add(Quiz("A qui doit-on la chanson « I shot the Sheriff» ?", "UB40", "Eric Clapton", "Jim Morrison", "Bob Marley",4))
        quizs.add(Quiz("Quel pays a remporté la coupe du monde de football en 2014 ?", "Allemagne", "Italie", "Brésil", "Argentine",1))
        quizs.add(Quiz("Dans quelle ville italienne l'action de la pièce de Shakespeare «Roméo et Juliette» se situe-t-elle ?", "Venise", "Vérone", "Milan", "Rome",2))
        quizs.add(Quiz("En quelle année Charlemagne se fait-il sacrer empereur ?", "756 ap.J.C", "800 ap.J.C", "787 ap.J.C", "843 ap.J.C",2))
        quizs.add(Quiz("Avec la laine de quel animal fait-on du cachemir ?", "mouton", "vison", "lapin", "chèvre",4))
        quizs.add(Quiz("Quel est l'album le plus vendu des Pink Floyd ?", "The Dark side of the moon", "The Wall", "The Final Cut", "Wish You Were Here",1))

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
            alert.setMessage("Tu as eu : " + numberOfGoodAnswers + " /8 de bonne(s) réponse(s)")
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