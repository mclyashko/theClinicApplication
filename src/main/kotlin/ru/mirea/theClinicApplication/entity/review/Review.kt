package ru.mirea.theClinicApplication.entity.review

import com.fasterxml.jackson.annotation.JsonIgnore
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class Review (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    @JsonIgnore
    var id: Long? = null,

    @OneToOne
    @MapsId
    @JoinColumn(name = "OWNER_ID")
    var appUser: AppUser? = null,

    @Column(name = "RATING")
    var rating: Short? = null,

    @Column(name = "COMMENTARY")
    var commentary: String? = null,

    @Column(name = "PUBLISHING_TIME")
    var publishingTime: LocalDateTime? = null
) {
    @PrePersist
    private fun onCreate() {
        publishingTime = LocalDateTime.now()
    }

    @PreUpdate
    private fun onUpdate() {
        publishingTime = LocalDateTime.now()
    }
}
