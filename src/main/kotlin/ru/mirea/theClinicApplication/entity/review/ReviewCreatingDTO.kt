package ru.mirea.theClinicApplication.entity.review

import javax.validation.constraints.Max
import javax.validation.constraints.Min

class ReviewCreatingDTO (
    var rating: @Min(value = 1) @Max(value = 5) Short? = null,

    var commentary: String? = null
)
