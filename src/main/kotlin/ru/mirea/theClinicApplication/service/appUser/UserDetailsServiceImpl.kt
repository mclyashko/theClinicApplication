package ru.mirea.theClinicApplication.service.appUser

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.mirea.theClinicApplication.repository.appUser.AppUserRepository

@Service
class UserDetailsServiceImpl @Autowired constructor(private val appUserRepository: AppUserRepository) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val appUser = appUserRepository.findByEmail(email)
            .orElseThrow { UsernameNotFoundException("user not found") }
        return User(
            appUser.email,
            appUser.password, listOf(SimpleGrantedAuthority("ROLE_" + appUser.appUserRole!!.name))
        )
    }
}
