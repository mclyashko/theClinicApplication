package ru.mirea.theClinicApplication.repository.procedure

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ru.mirea.theClinicApplication.entity.procedure.Procedure

@Repository
interface ProcedureRepository : JpaRepository<Procedure, Long>
