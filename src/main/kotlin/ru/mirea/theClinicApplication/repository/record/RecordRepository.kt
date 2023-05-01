package ru.mirea.theClinicApplication.repository.record

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import ru.mirea.theClinicApplication.entity.record.Record
import java.time.LocalDateTime

@Repository
interface RecordRepository : JpaRepository<Record, Long> {
    fun findAllByProcedure_ArtistInfo_Artist_id(artistId: Long): List<Record>
    fun findAllByProcedure_ArtistInfo_Artist_idAndClient_Email(artistId: Long, email: String): List<Record>
    fun findAllByClient_Id(clientId: Long): List<Record>
    fun findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqualAndProcedure_ArtistInfo_Artist_id(
        start: LocalDateTime, end: LocalDateTime, artistId: Long
    ): List<Record>

    @Modifying
    @Query("update Record r set r.verdict = ?1 where r.id = ?2")
    fun updateRecordVerdictById(verdict: String, recordId: Long)
}

