package ru.mirea.theClinicApplication.service.record

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mirea.theClinicApplication.entity.record.Record
import ru.mirea.theClinicApplication.repository.record.RecordRepository
import java.util.*
import java.util.stream.Collectors
import javax.transaction.Transactional

@Service
@Transactional
class RecordService @Autowired constructor(private val recordRepository: RecordRepository) {
    fun updateVerdictById(id: Long?, verdict: String?) {
        recordRepository.updateRecordVerdictById(verdict!!, id!!)
    }

    fun getRecordsSortedByDateWithNotNoneVerdictByDoctorId(id: Long?): List<Record> {
        return recordRepository.findAllByProcedure_ArtistInfo_Artist_id(
            id!!
        ).stream().filter { e: Record -> e.verdict == "None" }.sorted(RecordComparator()).collect(Collectors.toList())
    }

    fun getRecordsSortedByDateWithNotNoneVerdictByDoctorIdAndPatientEmail(id: Long?, email: String?): List<Record> {
        return recordRepository.findAllByProcedure_ArtistInfo_Artist_idAndClient_Email(
            id!!, email!!
        ).stream().filter { e: Record -> e.verdict == "None" }.sorted(RecordComparator()).collect(Collectors.toList())
    }

    fun getAllRecordsSortedByDateByPatientId(id: Long?): List<Record> {
        return recordRepository.findAllByClient_Id(
            id!!
        ).stream().sorted(RecordComparator()).collect(Collectors.toList())
    }

    fun getAllRecordsSortedByDateByPatientIdFilteredByProcedureDescription(id: Long?, description: String): List<Record> {
        return recordRepository.findAllByClient_Id(
            id!!
        ).stream().filter { e: Record ->
            e.procedure!!.description!!.uppercase().contains(description.uppercase(Locale.getDefault()))
        }.sorted(RecordComparator()).collect(Collectors.toList())
    }

    fun deleteRecordById(id: Long) {
        recordRepository.deleteById(id)
    }

    fun save(record: Record): String {
        val isTheRecordingTimeAvailable = recordRepository.findAllByDateTimeGreaterThanEqualAndDateTimeLessThanEqualAndProcedure_ArtistInfo_Artist_id(
            record.dateTime!!.minusMinutes(10),
            record.dateTime!!,
            record.procedure!!.artistInfo!!.artist!!.id!!
        ).isEmpty() // -10;0
        if (!isTheRecordingTimeAvailable) {
            return "wrong_time"
        }
        record.verdict = "None"
        recordRepository.save(record)
        return "ok_time"
    }
}

internal class RecordComparator : Comparator<Record> {
    override fun compare(o1: Record, o2: Record): Int {
        return o1.dateTime!!.compareTo(o2.dateTime)
    }
}

