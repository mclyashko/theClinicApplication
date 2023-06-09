package ru.mirea.theClinicApplication.entity.quiz

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Transient

@Entity
class Question (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
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
    @get:JsonIgnore
    val questionPoints: Int
        get() = when (choose) {
            1 -> (pointsA)!!
            2 -> (pointsB)!!
            3 -> (pointsC)!!
            else -> throw IllegalStateException(
                "Unexpected value for choose: $choose QuestionId: $id"
            )
        }

    @get:JsonIgnore
    val maxQuestionPoints: Int
        get() {
            return maxOf(
                pointsA!!, pointsB!!, pointsC!!
            )
        }

    @get:JsonIgnore
    val minQuestionPoints: Int
        get() {
            return minOf(
                pointsA!!, pointsB!!, pointsC!!
            )
        }
}

