package ru.mirea.theClinicApplication.controller.listOfServices

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.mirea.theClinicApplication.annotation.mailProc.SendMailProc
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.procedure.Procedure
import ru.mirea.theClinicApplication.entity.record.Record
import ru.mirea.theClinicApplication.service.appUser.AppUserService
import ru.mirea.theClinicApplication.service.procedure.ProcedureService
import ru.mirea.theClinicApplication.service.record.RecordService
import java.time.LocalDateTime

@Controller
class ListOfServicesController @Autowired constructor(
    private val appUserService: AppUserService, private val procedureService: ProcedureService,
    private val recordService: RecordService, private val sendMailHelper: SendMailHelper
) {
    @GetMapping("/list_of_services")
    @Secured(AppUserRole.patientFinalStr)
    fun getListOfServicesPage(model: Model): String {
        val appUser = appUserService.currentUser
        val procedureList = procedureService.allProceduresSortedByCoast
        model.addAttribute(
            "me",
            appUser
        )
        model.addAttribute(
            "services",
            procedureList
        )
        return "list_of_services"
    }

    @PostMapping("/make_an_appointment")
    @Secured(AppUserRole.patientFinalStr)
    fun makeAnAppointment(@ModelAttribute("newAppointmentInfo") newAppointmentInfo: NewAppointmentInfo): String {
        val appUser = appUserService.findById(newAppointmentInfo.clientId!!)
        val procedure = procedureService.findById(newAppointmentInfo.procedureId!!)
        val dateTime = newAppointmentInfo.dateTime!!
        sendMailHelper.getAppUserAndProcedureFromMakeAnAppointmentToSendEmail(appUser, procedure)
        val record = Record()
        record.client = appUser
        record.procedure = procedure
        record.dateTime = dateTime
        return recordService.save(record)
    }

    @PostMapping("fBPD")
    @Secured(AppUserRole.patientFinalStr)
    fun filterByProcedureDescription(@RequestParam procedureDescription: String?, model: Model): String {
        val appUser = appUserService.currentUser
        val procedureListFilteredByProcedureDescription: List<Procedure> = if (!procedureDescription.isNullOrEmpty()) {
            procedureService.getAllProceduresSortedByCoastFilteredByProcedureDescription(
                procedureDescription
            )
        } else {
            procedureService.allProceduresSortedByCoast
        }
        model.addAttribute(
            "me",
            appUser
        )
        model.addAttribute(
            "services",
            procedureListFilteredByProcedureDescription
        )
        return "list_of_services"
    }

    @get:Secured(AppUserRole.patientFinalStr)
    @get:GetMapping("/ok_time")
    val okPage: String
        get() = "ok_time"

    @get:Secured(AppUserRole.patientFinalStr)
    @get:GetMapping("/wrong_time")
    val wrongPage: String
        get() = "wrong_time"
}

class NewAppointmentInfo {
    var clientId: Long? = null
    var procedureId: Long? = null

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    var dateTime: LocalDateTime? = null
    override fun toString(): String {
        return "newAppointmentInfo{" +
                "clientId=" + clientId +
                ", procedureId=" + procedureId +
                ", dateTime=" + dateTime +
                '}'
    }
}

@Component
class SendMailHelper {
    @SendMailProc
    fun getAppUserAndProcedureFromMakeAnAppointmentToSendEmail(appUser: AppUser?, procedure: Procedure?) {
    }
}

