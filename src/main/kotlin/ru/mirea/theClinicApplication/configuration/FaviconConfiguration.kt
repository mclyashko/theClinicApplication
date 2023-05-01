package ru.mirea.theClinicApplication.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler
import java.util.*

@Configuration
class FaviconConfiguration {
    @Bean
    fun customFaviconHandlerMapping(): SimpleUrlHandlerMapping {
        val mapping = SimpleUrlHandlerMapping()
        mapping.order = Int.MIN_VALUE
        mapping.urlMap = Collections.singletonMap(
            "/public/favicon.ico", faviconRequestHandler()
        )
        return mapping
    }

    @Bean
    protected fun faviconRequestHandler(): ResourceHttpRequestHandler {
        val requestHandler = ResourceHttpRequestHandler()
        requestHandler.locations = listOf<Resource>(ClassPathResource("/"))
        return requestHandler
    }
}
