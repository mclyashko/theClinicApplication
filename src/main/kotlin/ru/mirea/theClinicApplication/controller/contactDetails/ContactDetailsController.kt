package ru.mirea.theClinicApplication.controller.contactDetails

import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole

@Controller
class ContactDetailsController {
    @get:Secured(AppUserRole.patientFinalStr)
    @get:GetMapping("/contact_details")
    val contactDetailsPage: String
        get() = "contact_details"
}
