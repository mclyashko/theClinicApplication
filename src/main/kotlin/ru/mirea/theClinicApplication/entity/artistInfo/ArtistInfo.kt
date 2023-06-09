package ru.mirea.theClinicApplication.entity.artistInfo

import com.fasterxml.jackson.annotation.JsonIgnore
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.procedure.Procedure
import javax.persistence.*

@Entity
class ArtistInfo (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    @JsonIgnore
    var id: Long? = null,

    @Column(nullable = false, unique = true)
    var cabinet: Long? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedure_id", insertable = false, updatable = false)
    @JsonIgnore
    var procedure: Procedure? = null,

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "artistInfo")
    var artist: AppUser? = null
)
