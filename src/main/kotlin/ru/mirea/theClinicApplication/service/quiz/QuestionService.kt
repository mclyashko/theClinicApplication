package ru.mirea.theClinicApplication.service.quiz

import org.springframework.stereotype.Service
import ru.mirea.theClinicApplication.entity.quiz.Question
import ru.mirea.theClinicApplication.entity.quiz.QuizWrapper
import ru.mirea.theClinicApplication.repository.quiz.QuestionRepository

@Service
class QuestionService(
    private val questionRepository: QuestionRepository
) {

    val allQuestions: List<Question>
        get() = questionRepository.findAll()

    fun getRecommendation(solutions: QuizWrapper): String {
        return solutions.result
    }
}

