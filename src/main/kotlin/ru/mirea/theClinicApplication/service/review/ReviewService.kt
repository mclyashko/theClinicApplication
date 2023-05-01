package ru.mirea.theClinicApplication.service.review

import org.springframework.stereotype.Service
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.review.Review
import ru.mirea.theClinicApplication.entity.review.ReviewCreatingDTO
import ru.mirea.theClinicApplication.entity.review.ReviewReturningDTO
import ru.mirea.theClinicApplication.repository.review.ReviewRepository
import ru.mirea.theClinicApplication.service.appUser.AppUserService
import javax.transaction.Transactional

@Service
@Transactional
class ReviewService(
    private val appUserService: AppUserService,
    private val reviewRepository: ReviewRepository
) {

    val allReviewReturningDTOs: List<ReviewReturningDTO>
        get() = mapToReturningDTO(reviewRepository.findByOrderByPublishingTimeDesc())

    fun createReview(reviewCreatingDTO: ReviewCreatingDTO) {
        val currentUser: AppUser = appUserService.currentUser
        var review = reviewRepository.findByAppUser(
            currentUser
        ).orElse(null)
        if (review == null) {
            review = Review()
            review.appUser = currentUser
        }
        review.rating = reviewCreatingDTO.rating
        review.commentary = reviewCreatingDTO.commentary
        reviewRepository.save(review)
    }

    private fun mapToReturningDTO(reviews: List<Review>): List<ReviewReturningDTO> {
        return reviews.parallelStream().map { review: Review ->
            ReviewReturningDTO(
                review.id,
                review.appUser!!.name,
                review.rating,
                review.commentary,
                review.publishingTime
            )
        }.toList()
    }
}

