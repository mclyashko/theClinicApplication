package ru.mirea.theClinicApplication.aspect.emailAspect

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import ru.mirea.theClinicApplication.entity.appUser.AppUser
import ru.mirea.theClinicApplication.entity.procedure.Procedure
import ru.mirea.theClinicApplication.services.mail.EmailService
import javax.annotation.PostConstruct

@Component
@Aspect
class EmailAspect @Autowired constructor(private val applicationContext: ApplicationContext) {
    private var emailService: EmailService? = null
    @PostConstruct
    fun setEmailService() {
        emailService = applicationContext.getBean(EmailService::class.java)
    }

    @Before("sendMailReg()")
    fun emailSendReg(joinPoint: JoinPoint) {
        val appUser = joinPoint.args[0] as AppUser
        emailService!!.sendNotification(
            "СПАСИБО ЗА РЕГИСТРАЦИЮ",
            appUser.email
        )
    }

    @Before("sendMailProc()")
    fun emailSendProc(joinPoint: JoinPoint) {
        val appUser = joinPoint.args[0] as AppUser
        val procedure = joinPoint.args[1] as Procedure
        emailService!!.sendNotification(
            "СОЗДАНА НОВАЯ ЗАПИСЬ НА ПРОЦЕДУРУ: " + procedure.description,
            appUser.email
        )
    }

    @Pointcut("@annotation(ru.mirea.theClinicApplication.annotation.mailReg.SendMailReg)")
    fun sendMailReg() {
    }

    @Pointcut("@annotation(ru.mirea.theClinicApplication.annotation.mailProc.SendMailProc)")
    fun sendMailProc() {
    }
}

