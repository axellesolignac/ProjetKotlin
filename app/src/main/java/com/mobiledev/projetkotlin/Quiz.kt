package com.mobiledev.projetkotlin

/*Création du modèle du quiz*/

class Quiz(var question: String, var answer1:String, var answer2:String, var answer3:String, var answer4:String, var correctAnswerNb: Int) {

    fun isCorrect(answerNumber:Int): Boolean {
        if (answerNumber == correctAnswerNb)
            return true
        return false
    }
}