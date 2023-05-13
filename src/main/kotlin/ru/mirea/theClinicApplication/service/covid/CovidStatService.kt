package ru.mirea.theClinicApplication.service.covid

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import ru.mirea.theClinicApplication.entity.covid.CovidStat

@Service
class CovidStatService {
    @Value("\${api.covid.key}")
    private val apiCovidKey: String? = null

    val ruStatistics: CovidStat
        get() {
            val restTemplate = RestTemplate()
            val uri = "https://covid-193.p.rapidapi.com/statistics?country=Russia"
            val httpHeaders = HttpHeaders()
            httpHeaders.accept = listOf(MediaType.APPLICATION_JSON)
            httpHeaders.add("X-RapidAPI-Key", apiCovidKey)
            httpHeaders.add("X-RapidAPI-Host", "covid-193.p.rapidapi.com")
            val body: MultiValueMap<String, String> = LinkedMultiValueMap()
            val entity = HttpEntity(body, httpHeaders)
            val result = restTemplate.exchange(uri, HttpMethod.GET, entity, CovidStat::class.java)
            return result.body!!
        }
}

