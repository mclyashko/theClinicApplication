package ru.mirea.theClinicApplication.aspect.loggingAspect

import lombok.extern.slf4j.Slf4j
import mu.KotlinLogging
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*

private val logger = KotlinLogging.logger {}

@Slf4j
@Component
@Aspect
class LoggingAspect() {
    @Before("allServiceMethods()")
    fun log(joinPoint: JoinPoint) {
        logger.info(
            "Awakening " + joinPoint.signature.name +
                    " method from " + joinPoint.target.javaClass +
                    " with args: " + Arrays.toString(joinPoint.args) +
                    " at " + LocalDateTime.now() +
                    ";"
        )
    }

    @Pointcut("within(ru.mirea.theClinicApplication.services..*)")
    fun allServiceMethods() {
    }
}
