package ru.mirea.theClinicApplication.handler.authentication

import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.security.core.Authentication
import org.springframework.security.web.WebAttributes
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import java.io.IOException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private val logger = KotlinLogging.logger {}

@Component
class CustomAuthenticationSuccessHandler : AuthenticationSuccessHandler {

    @Throws(IOException::class)
    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        handle(request, response, authentication)
        clearAuthenticationAttributes(request)
    }

    @Throws(IOException::class)
    protected fun handle(
        request: HttpServletRequest?,
        response: HttpServletResponse,
        authentication: Authentication
    ) {
        response.contentType = "application/json;charset=UTF-8"
        response.status = HttpStatus.OK.value()
        response.writer.write("{\"role\": \"${authentication.authorities.first().authority}\"}")
        response.writer.flush()
        response.writer.close()
    }

    protected fun determineTargetUrl(authentication: Authentication): String? {
        val roleTargetUrlMap: MutableMap<String, String> = HashMap()
        roleTargetUrlMap["ROLE_" + AppUserRole.PATIENT.name] = "/home_patient"
        roleTargetUrlMap["ROLE_" + AppUserRole.DOCTOR.name] = "/home_doctor"
        val authorities = authentication.authorities
        for (grantedAuthority in authorities) {
            val authorityName = grantedAuthority.authority
            if (roleTargetUrlMap.containsKey(authorityName)) {
                return roleTargetUrlMap[authorityName]
            }
        }
        throw IllegalStateException()
    }

    protected fun clearAuthenticationAttributes(request: HttpServletRequest) {
        val session = request.getSession(false) ?: return
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)
    }
}

