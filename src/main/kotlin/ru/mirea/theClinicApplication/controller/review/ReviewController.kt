package ru.mirea.theClinicApplication.controller.review

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.review.ReviewCreatingDTO
import ru.mirea.theClinicApplication.entity.review.ReviewReturningDTO
import ru.mirea.theClinicApplication.service.review.ReviewService
import javax.validation.Valid

@RestController
@RequestMapping("/review")
class ReviewController(
    private val reviewService: ReviewService
) {
    @GetMapping
    @Secured(AppUserRole.patientFinalStr)
    fun getReviewPage(): List<ReviewReturningDTO> {
        return reviewService.allReviewReturningDTOs
    }

    @PostMapping
    @Secured(AppUserRole.patientFinalStr)
    fun createNewReview(
        @RequestBody reviewCreatingDTO: @Valid ReviewCreatingDTO?
    ): ResponseEntity<Unit> {
        reviewService.createReview(reviewCreatingDTO!!)
        return ResponseEntity(HttpStatus.OK)
    }
}

