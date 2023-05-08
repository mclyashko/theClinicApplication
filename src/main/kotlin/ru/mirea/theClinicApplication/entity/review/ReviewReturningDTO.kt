package ru.mirea.theClinicApplication.entity.review

import java.time.LocalDateTime

class ReviewReturningDTO (
    var id: Long? = null,

    var appUserName: String? = null,

    var rating: Short? = null,

    var commentary: String? = null,

    var publishingTime: LocalDateTime? = null
)
