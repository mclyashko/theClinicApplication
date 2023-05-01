package ru.mirea.theClinicApplication.handler.authentication

import mu.KotlinLogging
import org.springframework.security.core.Authentication
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy
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
    private val redirectStrategy: RedirectStrategy

    init {
        redirectStrategy = DefaultRedirectStrategy()
    }

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
        val targetUrl = determineTargetUrl(authentication)
        if (response.isCommitted) {
            logger.info(
                "Response has already been committed. Unable to redirect to " +
                        targetUrl
            )
            return
        }
        redirectStrategy.sendRedirect(request, response, targetUrl)
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

