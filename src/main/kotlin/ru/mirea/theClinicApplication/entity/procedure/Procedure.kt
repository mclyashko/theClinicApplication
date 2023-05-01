package ru.mirea.theClinicApplication.entity.procedure

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import ru.mirea.theClinicApplication.entity.artistInfo.ArtistInfo
import ru.mirea.theClinicApplication.entity.record.Record
import javax.persistence.*

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Procedure (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    @JsonIgnore
    var id: Long? = null,

    @Column(nullable = false)
    var description: String? = null,

    @Column(nullable = false)
    var cost: Double = 0.0,

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "procedure")
    @JsonIgnore
    var recordList: List<Record>? = null,

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "procedure")
    @JsonIgnore
    var artistInfo: ArtistInfo? = null
) {
    override fun toString(): String {
        return "Procedure{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}'
    }

    @PrePersist
    private fun onCreate() {
        cost = cost * 1.37 + 123
    }

    @PreUpdate
    private fun onUpdate() {
        cost = cost * 1.37 + 123
    }
}

