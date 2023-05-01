package ru.mirea.theClinicApplication.entity.review

import lombok.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
class ReviewCreatingDTO (
    var rating: @Min(value = 1) @Max(value = 5) Short? = null,

    var commentary: String? = null
)
