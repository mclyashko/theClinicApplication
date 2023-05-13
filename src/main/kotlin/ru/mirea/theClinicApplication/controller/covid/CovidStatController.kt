package ru.mirea.theClinicApplication.controller.covid

import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.entity.covid.CovidStat
import ru.mirea.theClinicApplication.service.covid.CovidStatService

@RestController
class NewCovidStatController(
    private val covidStatService: CovidStatService
) {
    @GetMapping("/covid_stat")
    @Secured(AppUserRole.patientFinalStr)
    fun getCovidStat(): CovidStat {
        return covidStatService.ruStatistics
    }
}
