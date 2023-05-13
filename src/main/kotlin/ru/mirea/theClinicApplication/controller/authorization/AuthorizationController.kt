package ru.mirea.theClinicApplication.controller.authorization

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.mirea.theClinicApplication.annotation.mailReg.SendMailReg
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.service.appUser.AppUserService

@RestController
class AuthorizationController(
    private val appUserService: AppUserService
) {
    @PostMapping("/registration")
    @SendMailReg
    fun registerUser(@RequestBody user: AppUser): ResponseEntity<Unit> {
        appUserService.save(user)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping("/get_current_user")
    fun getCurrentUser(): AppUser {
        return appUserService.currentUser
    }
}

