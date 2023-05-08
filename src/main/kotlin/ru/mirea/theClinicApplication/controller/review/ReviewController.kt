package ru.mirea.theClinicApplication.controller.review

import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.review.ReviewCreatingDTO
import ru.mirea.theClinicApplication.service.review.ReviewService
import javax.validation.Valid

@Controller
@RequestMapping("/review")
class ReviewController(
    private val reviewService: ReviewService
) {
    @GetMapping
    @Secured(AppUserRole.patientFinalStr)
    fun getReviewPage(model: Model): String {
        val reviews = reviewService.allReviewReturningDTOs
        model.addAttribute("reviews", reviews)
        return "review"
    }

    @PostMapping
    @Secured(AppUserRole.patientFinalStr)
    fun createNewReview(
        @ModelAttribute(name = "review") reviewCreatingDTO: @Valid ReviewCreatingDTO?,
        model: Model
    ): String {
        reviewService.createReview(reviewCreatingDTO!!)
        val reviews = reviewService.allReviewReturningDTOs
        model.addAttribute("reviews", reviews)
        return "review"
    }
}

