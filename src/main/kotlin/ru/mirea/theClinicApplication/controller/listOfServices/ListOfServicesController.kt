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
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.mirea.theClinicApplication.annotation.mailProc.SendMailProc
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.procedure.Procedure
import ru.mirea.theClinicApplication.entity.record.Record
import ru.mirea.theClinicApplication.service.appUser.AppUserService
import ru.mirea.theClinicApplication.service.procedure.ProcedureService
import ru.mirea.theClinicApplication.service.record.RecordService
import java.time.LocalDateTime

@RestController
class ListOfServicesController @Autowired constructor(
    private val appUserService: AppUserService, private val procedureService: ProcedureService,
    private val recordService: RecordService, private val sendMailHelper: SendMailHelper
) {
    @PostMapping("/list_of_services")
    @Secured(AppUserRole.patientFinalStr)
    fun getListOfServicesPage(@RequestBody(required = false) procedureDescription: FilterServicesRequestBody?): List<Procedure> {
        return procedureDescription?.let {
            procedureService.getAllProceduresSortedByCoastFilteredByProcedureDescription(
                procedureDescription.procedureDescription
            )
        } ?: procedureService.allProceduresSortedByCoast
    }

    @PostMapping("/make_an_appointment")
    @Secured(AppUserRole.patientFinalStr)
    fun makeAnAppointment(@RequestBody newAppointmentInfo: NewAppointmentInfo): NewAppointmentResponseBody {
        val appUser = appUserService.findById(newAppointmentInfo.clientId!!)
        val procedure = procedureService.findById(newAppointmentInfo.procedureId!!)
        val dateTime = newAppointmentInfo.dateTime!!
        sendMailHelper.getAppUserAndProcedureFromMakeAnAppointmentToSendEmail(appUser, procedure)
        val record = Record()
        record.client = appUser
        record.procedure = procedure
        record.dateTime = dateTime
        return if (recordService.save(record) == "ok_time") {
            NewAppointmentResponseBody(true)
        } else {
            NewAppointmentResponseBody(false)
        }
    }
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

data class FilterServicesRequestBody(
    val procedureDescription: String
)

data class NewAppointmentResponseBody(
    val status: Boolean
)

@Component
class SendMailHelper {
    @SendMailProc
    fun getAppUserAndProcedureFromMakeAnAppointmentToSendEmail(appUser: AppUser?, procedure: Procedure?) {
    }
}

