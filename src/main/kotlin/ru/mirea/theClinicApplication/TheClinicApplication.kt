package ru.mirea.theClinicApplication

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TheClinicApplication

fun main(args: Array<String>) {
	runApplication<TheClinicApplication>(*args)
}
