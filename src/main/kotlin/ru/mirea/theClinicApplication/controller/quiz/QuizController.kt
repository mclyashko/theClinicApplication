package ru.mirea.theClinicApplication.controller.quiz

import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.quiz.QuizWrapper
import ru.mirea.theClinicApplication.service.quiz.QuestionService

@Controller
@RequestMapping("/quiz")
class QuizController(
    private val questionService: QuestionService
) {
    @GetMapping
    @Secured(AppUserRole.patientFinalStr)
    fun getQuizPage(model: Model): String {
        val questions = questionService.allQuestions
        model.addAttribute("quiz", QuizWrapper(questions))
        return "quiz"
    }

    @PostMapping("/results")
    @Secured(AppUserRole.patientFinalStr)
    fun calculateResult(
        @ModelAttribute(value = "quiz") solutions: QuizWrapper?,
        model: Model
    ): String {
        val recommendation = questionService.getRecommendation(solutions!!)
        model.addAttribute("results", recommendation)
        return "quiz_results"
    }
}
