package ru.mirea.theClinicApplication.service.appUser

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.repository.appUser.AppUserRepository
import javax.transaction.Transactional

@Service
@Transactional
class AppUserService @Autowired constructor(private val appUserRepository: AppUserRepository, private val passwordEncoder: PasswordEncoder) {
    fun save(appUser: AppUser): String {
        val isUserAlreadyExists = appUserRepository.findByEmail(appUser.email!!).isPresent ||
                appUserRepository.findByPhoneNumber(appUser.phoneNumber!!).isPresent
        if (isUserAlreadyExists) {
            return "user_already_exists"
        }
        appUser.password = passwordEncoder.encode(appUser.password)
        appUser.appUserRole = AppUserRole.PATIENT
        appUserRepository.save(appUser)
        return "login"
    }

    fun findByUsername(email: String?): AppUser? {
        val appUser = appUserRepository.findByEmail(email!!)
        return if (appUser.isEmpty) {
            null
        } else appUser.get()
    }

    fun findById(Id: Long): AppUser {
        return appUserRepository.getById(Id)
    }

    val currentUser: AppUser
        get() {
            val authentication = SecurityContextHolder.getContext().authentication
            val principal = authentication.principal as User
            return appUserRepository.findByEmail(principal.username)
                .orElseThrow { IllegalArgumentException("user not found") }
        }
}

