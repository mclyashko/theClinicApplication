package ru.mirea.theClinicApplication.entity.covid

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class CovidStat (
    var response: List<Response>? = null
)

@Component
class Response (
    var country: String? = null,
    var population: Long? = null,
    var cases: Cases? = null,
    var deaths: Deaths? = null,
    var tests: Tests? = null,
    var day: LocalDate? = null,
)

@Component
class Cases (
    @JsonProperty(value = "new")
    var newCases: String? = null,
    var active: Long? = null,
    var critical: Long? = null,
    var recovered: Long? = null
)

@Component
class Deaths (
    @JsonProperty(value = "new")
    var newDeaths: String? = null,
    var total: String? = null
)

@Component
class Tests (
    var total: String? = null
)
