package ru.mirea.theClinicApplication.entity.quiz

import org.springframework.stereotype.Component

@Component
class QuizWrapper(var questions: List<Question>? = null) {

    val quizPoints: Int
        get() {
            var points = 0
            for (question in questions!!) {
                points += question.questionPoints
            }
            return points
        }

    val maxQuizPoints: Int
        get() {
            var points = 0
            for (question in questions!!) {
                points += question.maxQuestionPoints
            }
            return points
        }

    val minQuizPoints: Int
        get() {
            var points = 0
            for (question in questions!!) {
                points += question.minQuestionPoints
            }
            return points
        }

    val result: String
        get() {
            val quizPoints = quizPoints
            val maxQuizPoints = maxQuizPoints
            val minQuizPoints = minQuizPoints
            val amplitude = maxQuizPoints - minQuizPoints
            val absoluteQuizPoints = quizPoints - minQuizPoints
            val percent = absoluteQuizPoints * 100.0 / amplitude
            val recommendation = if (percent > 80.0) "У вас прекрасное состояние здоровья" else if (percent > 50.0) "У вас хорошее состояние здоровья" else "Вам стоит обратиться к врачу-специалисту"
            return """Вы набрали $quizPoints очков;
Минимум очков: $minQuizPoints;
Максимум очков: $maxQuizPoints;
Ваша рекомендация: $recommendation"""
        }
}
