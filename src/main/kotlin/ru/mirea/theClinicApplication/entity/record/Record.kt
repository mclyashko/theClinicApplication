package ru.mirea.theClinicApplication.entity.record

import com.fasterxml.jackson.annotation.JsonIgnore
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.springframework.format.annotation.DateTimeFormat
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.procedure.Procedure
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Record (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    @JsonIgnore
    var id: Long? = null,

    @Column(nullable = false)
    var verdict: String? = null,

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    var dateTime: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", updatable = false)
    @JsonIgnore
    var client: AppUser? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "procedure_id", updatable = false)
    @JsonIgnore
    var procedure: Procedure? = null,

) {
    override fun toString(): String {
        return "Record{" +
                "id=" + id +
                ", verdict='" + verdict + '\'' +
                ", dateTime=" + dateTime +
                ", client=" + client +
                ", procedure=" + procedure +
                '}'
    }
}
