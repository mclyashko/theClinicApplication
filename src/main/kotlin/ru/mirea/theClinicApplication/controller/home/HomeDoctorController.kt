package ru.mirea.theClinicApplication.controller.home

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.record.Record
import ru.mirea.theClinicApplication.service.appUser.AppUserService
import ru.mirea.theClinicApplication.service.record.RecordService

@RestController
class HomeDoctorController @Autowired constructor(private val appUserService: AppUserService, private val recordService: RecordService) {
    @PostMapping("filterByEmail")
    @Secured(AppUserRole.doctorFinalStr)
    fun filterRecordsByEmail(@RequestBody(required = false) request: FilterRequest): List<Record> {
        val appUser = appUserService.currentUser
        val records = request.email?.let {
            recordService.getRecordsSortedByDateWithNotNoneVerdictByDoctorIdAndPatientEmail(
                appUser.id, request.email
            )
        } ?: recordService.getRecordsSortedByDateWithNotNoneVerdictByDoctorId(
            appUser.id
        )
        return records
    }

    @PostMapping("/record_data")
    @Secured(AppUserRole.doctorFinalStr)
    fun addData(@RequestBody recordVerdictData: RecordVerdictData): ResponseEntity<Unit> {
        recordService.updateVerdictById(recordVerdictData.id, recordVerdictData.verdict)
        return ResponseEntity(HttpStatus.OK)
    }
}

data class RecordVerdictData (
    var id: Long? = null,
    var verdict: String? = null
)

data class FilterRequest(
    val email: String?
)
