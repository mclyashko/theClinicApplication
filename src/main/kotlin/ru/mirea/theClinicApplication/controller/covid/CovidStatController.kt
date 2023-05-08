package ru.mirea.theClinicApplication.controller.covid

import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import ru.mirea.theClinicApplication.entity.appUser.AppUserRole
import ru.mirea.theClinicApplication.service.covid.CovidStatService

@Controller
@RequestMapping("/covid_stat")
class CovidStatController(
    private val covidStatService: CovidStatService
) {
    @GetMapping
    @Secured(AppUserRole.patientFinalStr)
    fun getCovidStat(model: Model): String {
        val covidStat = covidStatService.ruStatistics
        model.addAttribute("covidStat", covidStat)
        return "covid_stat"
    }
}
