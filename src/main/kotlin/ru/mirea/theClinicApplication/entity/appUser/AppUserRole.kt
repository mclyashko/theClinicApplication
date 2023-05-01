package ru.mirea.theClinicApplication.entity.appUser

import org.springframework.security.core.GrantedAuthority

enum class AppUserRole : GrantedAuthority {
    DOCTOR,
    PATIENT;

    override fun getAuthority(): String? {
        return name
    }

    companion object {
        const val doctorFinalStr = "DOCTOR"
        const val patientFinalStr = "PATIENT"
    }
}
