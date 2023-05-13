package ru.mirea.theClinicApplication.configuration

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.handler.authentication.CustomAuthenticationSuccessHandler
import ru.mirea.theClinicApplication.handler.authorization.CustomAuthenticationFailureHandler
import ru.mirea.theClinicApplication.service.appUser.UserDetailsServiceImpl
import java.util.concurrent.TimeUnit

@Configuration
@EnableWebSecurity
class SecurityConfiguration @Autowired constructor(
    private val userDetailsService: UserDetailsServiceImpl,
    private val customAuthenticationFailureHandler: CustomAuthenticationFailureHandler,
    private val customAuthenticationSuccessHandler: CustomAuthenticationSuccessHandler
) : WebSecurityConfigurerAdapter() {

    public override fun configure(http: HttpSecurity) {
        http
            .cors().configurationSource {
                val cors = CorsConfiguration()
                cors.allowedOrigins = listOf("http://localhost:3000")
                cors.allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "OPTIONS")
                cors.allowedHeaders = listOf("*")
                cors.allowCredentials = true
                cors
            }
            .and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(
                "/login", "/logout", "/registration",
                "/authentication_failure", "/user_already_exists",
                "/favicon.ico", "/get_current_user"
            )
            .permitAll() // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            .antMatchers("/home_doctor").hasRole(AppUserRole.DOCTOR.name)
            .antMatchers("/record_data").hasRole(AppUserRole.DOCTOR.name)
            .antMatchers("/filterByEmail").hasRole(AppUserRole.DOCTOR.name)
            .antMatchers("/home_patient").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/cancel_entry").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/filterByProcedureDescription").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/contact_details").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/list_of_services").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/fBPD").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/make_an_appointment").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/wrong_time").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/ok_time").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/quiz").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/quiz/results").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/covid_stat").hasRole(AppUserRole.PATIENT.name)
            .antMatchers("/review").hasRole(AppUserRole.PATIENT.name) // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .failureHandler(customAuthenticationFailureHandler)
            .successHandler(customAuthenticationSuccessHandler)
            .and()
            .httpBasic()
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .and()
            .rememberMe()
            .tokenValiditySeconds(TimeUnit.MINUTES.toSeconds(5).toInt())
            .and()
            .userDetailsService(userDetailsService)
            .sessionManagement()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", CorsConfiguration().applyPermitDefaultValues())
        return source
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun authProvider(): DaoAuthenticationProvider { // валидация
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(passwordEncoder())
        return authProvider
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
        auth.authenticationProvider(authProvider())
    }
}

