package ru.mirea.theClinicApplication.controller.authorization

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import ru.mirea.theClinicApplication.annotation.mailReg.SendMailReg
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.service.appUser.AppUserService

@Controller
class AuthorizationController @Autowired constructor(private val appUserService: AppUserService) {

    @get:GetMapping("/login")
    val loginPage: String
        get() = "login"

    @get:GetMapping("/registration")
    val registrationPage: String
        get() = "registration"

    @PostMapping("/registration")
    @SendMailReg
    fun registerUser(@ModelAttribute("user") user: AppUser?): String {
        return appUserService.save(user!!)
    }

    @get:GetMapping("/authentication_failure")
    val authenticationFailurePage: String
        get() = "authentication_failure"
}

