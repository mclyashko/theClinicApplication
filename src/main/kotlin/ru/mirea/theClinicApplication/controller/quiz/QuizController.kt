package ru.mirea.theClinicApplication.controller.quiz

import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.quiz.Question
import ru.mirea.theClinicApplication.entity.quiz.QuizWrapper
import ru.mirea.theClinicApplication.service.quiz.QuestionService

@RestController
class QuizController(
    private val questionService: QuestionService
) {
    @GetMapping("/quiz")
    @Secured(AppUserRole.patientFinalStr)
    fun getQuizPage(): List<Question> {
        return questionService.allQuestions
    }

    @PostMapping("/quiz/results")
    @Secured(AppUserRole.patientFinalStr)
    fun calculateResult(
        @RequestBody solutions: List<Question>
    ): ReturnRecommendationDto {
        val recommendation = questionService.getRecommendation(
            QuizWrapper(solutions)
        )
        return ReturnRecommendationDto(recommendation)
    }
}

data class ReturnRecommendationDto(
    val recommendation: String
)
