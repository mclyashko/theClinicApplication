package ru.mirea.theClinicApplication.entity.appUser

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.format.annotation.DateTimeFormat
import ru.mirea.theClinicApplication.entity.artistInfo.ArtistInfo
import ru.mirea.theClinicApplication.entity.record.Record
import java.util.*
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.Size

@Entity
class AppUser (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    var id: Long? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    var surname: String? = null,

    @Column(nullable = false)
    var patronymic: String? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var gender: AppUserGender? = null,

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    var dateOfBirth: Date? = null,

    @Column(nullable = false, unique = true)
    var phoneNumber: @Size(min = 11, max = 11, message = "Num should be exact 11 char") String? = null,

    @Column(nullable = false, unique = true)
    var email // email = login
            : @Email String? = null,

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    var appUserRole: AppUserRole? = null,

    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    var password: String? = null,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    @JsonIgnore
    var records: List<Record> = ArrayList(),

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_info_id", insertable = false, updatable = false)
    @JsonIgnore
    private val artistInfo: ArtistInfo? = null
) {
    override fun toString(): String {
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", gender=" + gender +
                ", dateOfBirth=" + dateOfBirth +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}'
    }

    @PrePersist
    private fun onCreate() {
        updater()
    }

    @PreUpdate
    private fun onUpdate() {
        updater()
    }

    private fun updater() {
        name = name!!.substring(0, 1).uppercase(Locale.getDefault()) + name!!.substring(1)
        surname = surname!!.substring(0, 1).uppercase(Locale.getDefault()) + surname!!.substring(1)
        patronymic = patronymic!!.substring(0, 1).uppercase(Locale.getDefault()) + patronymic!!.substring(1)
    }
}
