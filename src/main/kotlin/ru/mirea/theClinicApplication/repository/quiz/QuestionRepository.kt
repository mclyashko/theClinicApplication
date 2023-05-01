package ru.mirea.theClinicApplication.repository.quiz

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mirea.theClinicApplication.entity.quiz.Question

@Repository
interface QuestionRepository : JpaRepository<Question, Long>
