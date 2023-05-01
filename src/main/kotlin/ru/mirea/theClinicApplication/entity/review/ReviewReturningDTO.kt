package ru.mirea.theClinicApplication.entity.review

import lombok.*
import java.time.LocalDateTime

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
class ReviewReturningDTO (
    var id: Long? = null,

    var appUserName: String? = null,

    var rating: Short? = null,

    var commentary: String? = null,

    var publishingTime: LocalDateTime? = null
)
