package ru.mirea.theClinicApplication.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfiguration {

    @Value("\${cors.front-link}")
    lateinit var corsFrontLink: String

    @Bean
    fun configure(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(reg: CorsRegistry) {
                reg.addMapping("/**").allowedOrigins(corsFrontLink)
            }
        }
    }
}
