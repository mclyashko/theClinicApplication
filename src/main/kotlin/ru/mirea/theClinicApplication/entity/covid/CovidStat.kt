package ru.mirea.theClinicApplication.entity.covid

import com.fasterxml.jackson.annotation.JsonProperty
import lombok.*
import org.springframework.stereotype.Component
import java.time.LocalDate

@Setter
@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class CovidStat (
    var response: List<Response>? = null
)

@Setter
@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Response (
    var country: String? = null,
    var population: Long? = null,
    var cases: Cases? = null,
    var deaths: Deaths? = null,
    var tests: Tests? = null,
    var day: LocalDate? = null,
)

@Setter
@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Cases (
    @JsonProperty(value = "new")
    var newCases: String? = null,
    var active: Long? = null,
    var critical: Long? = null,
    var recovered: Long? = null
)

@Setter
@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Deaths (
    @JsonProperty(value = "new")
    var newDeaths: String? = null,
    var total: String? = null
)

@Setter
@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Tests (
    var total: String? = null
)
