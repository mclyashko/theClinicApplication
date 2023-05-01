package ru.mirea.theClinicApplication.entity.quiz

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.*
import javax.persistence.*

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Question (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    @JsonIgnore
    var id: Long? = null,

    @Column(name = "TITLE")
    var title: String? = null,

    @Column(name = "OPTION_A")
    var optionA: String? = null,

    @Column(name = "OPTION_B")
    var optionB: String? = null,

    @Column(name = "OPTION_C")
    var optionC: String? = null,

    @Column(name = "POINTS_A")
    var pointsA: Int? = null,

    @Column(name = "POINTS_B")
    var pointsB: Int? = null,

    @Column(name = "POINTS_C")
    var pointsC: Int? = null,

    @Transient
    var choose: Int? = null
) {
    val questionPoints: Int
        get() = when (choose) {
            1 -> (pointsA)!!
            2 -> (pointsB)!!
            3 -> (pointsC)!!
            else -> throw IllegalStateException(
                "Unexpected value for choose: $choose QuestionId: $id"
            )
        }

    val maxQuestionPoints: Int
        get() {
            return maxOf(
                pointsA!!, pointsB!!, pointsC!!
            )
        }

    val minQuestionPoints: Int
        get() {
            return maxOf(
                pointsA!!, pointsB!!, pointsC!!
            )
        }
}

