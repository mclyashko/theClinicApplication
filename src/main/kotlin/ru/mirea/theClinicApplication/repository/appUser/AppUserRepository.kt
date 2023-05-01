package ru.mirea.theClinicApplication.repository.appUser

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import java.util.*

@Repository
interface AppUserRepository : JpaRepository<AppUser, Long> {
    fun findByEmail(email: String): Optional<AppUser> // email = login
    fun findByPhoneNumber(phoneNumber: String): Optional<AppUser>
}
