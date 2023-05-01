package ru.mirea.theClinicApplication.service.mail

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Service
class EmailService @Autowired constructor(private val javaMailSender: JavaMailSender) {
    @Async
    fun sendNotification(text: String?, EMAIL_TO: String?) {
        val mail = SimpleMailMessage()
        mail.from = EMAIL_FROM
        mail.setTo(EMAIL_TO)
        mail.subject = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(LocalDateTime.now())
        mail.text = text
        javaMailSender.send(mail)
    }

    companion object {
        const val EMAIL_FROM = "jtask21@rambler.ru"
    }
}

