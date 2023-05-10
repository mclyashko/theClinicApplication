package ru.mirea.theClinicApplication.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMvcConfiguration {
    @Bean
    fun configure(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addCorsMappings(reg: CorsRegistry) {
                reg.addMapping("/**").allowedOrigins("http://localhost:3000")
            }
        }
    }
}
