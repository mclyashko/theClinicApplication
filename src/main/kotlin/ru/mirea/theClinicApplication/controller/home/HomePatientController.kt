package ru.mirea.theClinicApplication.controller.home

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.record.Record
import ru.mirea.theClinicApplication.service.appUser.AppUserService
import ru.mirea.theClinicApplication.service.record.RecordService

@RestController
class NewHomePatientController @Autowired constructor(private val appUserService: AppUserService, private val recordService: RecordService) {
    @PostMapping("/home_patient")
    @Secured(AppUserRole.patientFinalStr)
    fun filterByProcedureDescription(@RequestBody(required = false) procedureDescription: ProcedureDescription?): List<Record> {
        val appUser = appUserService.currentUser
        val recordsWithAppUserIdSortedByDateFilteredByProcedureDescription: List<Record> = procedureDescription?.let {
            recordService.getAllRecordsSortedByDateByPatientIdFilteredByProcedureDescription(
                appUser.id, procedureDescription.description
            )
        } ?: recordService.getAllRecordsSortedByDateByPatientId(
            appUser.id
        )

        return recordsWithAppUserIdSortedByDateFilteredByProcedureDescription
    }

    @PostMapping("/cancel_entry")
    @Secured(AppUserRole.patientFinalStr)
    fun cancelEntry(@RequestBody deleteRecordInfo: DeleteRecordInfo): ResponseEntity<Unit> {
        recordService.deleteRecordById(deleteRecordInfo.id!!)
        return ResponseEntity(HttpStatus.OK)
    }
}

data class ProcedureDescription(
    val description: String
)

data class DeleteRecordInfo(
    var id: Long? = null
)
