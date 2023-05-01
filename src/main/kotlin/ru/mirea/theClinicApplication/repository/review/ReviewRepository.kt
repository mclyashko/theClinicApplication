package ru.mirea.theClinicApplication.repository.review

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.review.Review
import java.util.*

@Repository
interface ReviewRepository : JpaRepository<Review, Long> {
    fun findByAppUser(appUser: AppUser): Optional<Review>
    fun findByOrderByPublishingTimeDesc(): List<Review>
}
