package com.quizapp

import com.quizapp.R
import com.quizapp.Question

object Constants {

    // TODO (STEP 1: Create a constant variables which we required in the result screen.)
    // START
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    // END

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(1,
            "Capital city of Kazakhstan",
            "Moscow",
            "Nur-Sultan",
            "Minsk",
            "Madrid",
            2);

        val que2 = Question(2,
            "Capital city of Spain",
            "Moscow",
            "Berlin",
            "London",
            "Madrid",
            4);

        val que3 = Question(3,
            "Capital city of England",
            "London",
            "Berlin",
            "Paris",
            "Warsaw",
            1);

        val que4 = Question(4,
            "Capital city of Poland",
            "London",
            "Warsaw",
            "Minsk",
            "Bratislava",
            2);

        val que5 = Question(5, "Capital city of Argentina",
            "Brasilia",
            "Warsaw",
            "Buenos Aires",
            "Madrid",
            3);

        val que6 = Question(6, "Capital city of Egypt",
            "Brasilia",
            "Cairo",
            "Buenos Aires",
            "Algiers",
            2);
        val que7 = Question(7, "Capital city of Japan",
            "Tokyo",
            "Cairo",
            "Seoul",
            "Algiers",
            1);

        val que8 = Question(8, "Capital city of South Korea",
            "Tokyo",
            "Cairo",
            "Seoul",
            "Berlin",
            3);

        val que9 = Question(9, "Capital city of Slovenia",
            "Ljubljana",
            "Belgrade",
            "Luxembourg",
            "Brasilia",
            1);
        val que10 = Question(10, "Capital city of Australia",
            "Vienna",
            "Ljubljana",
            "Budapest",
            "Canberra",
            4);



        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)

        return questionsList

    }
}