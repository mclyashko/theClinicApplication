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
class HomePatientController @Autowired constructor(private val appUserService: AppUserService, private val recordService: RecordService) {
    @GetMapping("/home_patient")
    @Secured(AppUserRole.patientFinalStr)
    fun getHomePage(model: Model): String {
        val appUser = appUserService.currentUser
        val allRecordsWithAppUserIdSortedByDate = recordService.getAllRecordsSortedByDateByPatientId(
            appUser.id
        )
        model.addAttribute(
            "me",
            appUser
        )
        model.addAttribute(
            "records",
            allRecordsWithAppUserIdSortedByDate
        )
        return "home_patient"
    }

    @PostMapping("/cancel_entry")
    @Secured(AppUserRole.patientFinalStr)
    fun cancelEntry(@ModelAttribute("deleteRecordInfo") deleteRecordInfo: DeleteRecordInfo): ModelAndView {
        recordService.deleteRecordById(deleteRecordInfo.id!!)
        return ModelAndView("redirect:/home_patient")
    }

    @PostMapping("filterByProcedureDescription")
    @Secured(AppUserRole.patientFinalStr)
    fun filterByProcedureDescription(@RequestParam procedureDescription: String?, model: Model): String {
        val appUser = appUserService.currentUser
        val recordsWithAppUserIdSortedByDateFilteredByProcedureDescription: List<Record> = if (!procedureDescription.isNullOrEmpty()) {
            recordService.getAllRecordsSortedByDateByPatientIdFilteredByProcedureDescription(
                appUser.id, procedureDescription
            )
        } else {
            recordService.getAllRecordsSortedByDateByPatientId(
                appUser.id
            )
        }
        model.addAttribute(
            "me",
            appUser
        )
        model.addAttribute(
            "records",
            recordsWithAppUserIdSortedByDateFilteredByProcedureDescription
        )
        return "home_patient"
    }
}

data class DeleteRecordInfo (
    var id: Long? = null
)
