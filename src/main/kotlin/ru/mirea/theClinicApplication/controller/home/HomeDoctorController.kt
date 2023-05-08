package ru.mirea.theClinicApplication.controller.home

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.ModelAndView
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.record.Record
import ru.mirea.theClinicApplication.service.appUser.AppUserService
import ru.mirea.theClinicApplication.service.record.RecordService

@Controller
class HomeDoctorController @Autowired constructor(private val appUserService: AppUserService, private val recordService: RecordService) {
    @GetMapping("/home_doctor")
    @Secured(AppUserRole.doctorFinalStr)
    fun getHomePage(model: Model): String {
        val appUser = appUserService.currentUser
        val notNullRecordsWithAppUserIdSortedByDate = recordService.getRecordsSortedByDateWithNotNoneVerdictByDoctorId(
            appUser.id
        )
        model.addAttribute(
            "me",
            appUser
        )
        model.addAttribute(
            "records",
            notNullRecordsWithAppUserIdSortedByDate
        )
        model.addAttribute("recordData", RecordVerdictData())
        return "home_doctor"
    }

    @PostMapping("/record_data")
    @Secured(AppUserRole.doctorFinalStr)
    fun addData(@ModelAttribute("recordData") recordVerdictData: RecordVerdictData): ModelAndView {
        recordService.updateVerdictById(recordVerdictData.id, recordVerdictData.verdict)
        return ModelAndView("redirect:/home_doctor")
    }

    @PostMapping("filterByEmail")
    @Secured(AppUserRole.doctorFinalStr)
    fun filterRecordsByEmail(@RequestParam email: String?, model: Model): String {
        val appUser = appUserService.currentUser
        val notNullRecordsWithAppUserIdAndPatientEmailSortedByDate: List<Record> = if (!email.isNullOrEmpty()) {
            recordService.getRecordsSortedByDateWithNotNoneVerdictByDoctorIdAndPatientEmail(
                appUser.id, email
            )
        } else {
            recordService.getRecordsSortedByDateWithNotNoneVerdictByDoctorId(
                appUser.id
            )
        }
        model.addAttribute(
            "me",
            appUser
        )
        model.addAttribute(
            "records",
            notNullRecordsWithAppUserIdAndPatientEmailSortedByDate
        )
        model.addAttribute("recordData", RecordVerdictData())
        return "home_doctor"
    }
}

data class RecordVerdictData (
    var id: Long? = null,
    var verdict: String? = null
)
