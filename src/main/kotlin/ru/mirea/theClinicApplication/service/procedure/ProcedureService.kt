package ru.mirea.theClinicApplication.service.procedure

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.mirea.theClinicApplication.entity.procedure.Procedure
import ru.mirea.theClinicApplication.repository.procedure.ProcedureRepository
import java.util.*
import java.util.stream.Collectors

@Service
class ProcedureService @Autowired constructor(private val procedureRepository: ProcedureRepository) {

    val allProceduresSortedByCoast: List<Procedure>
        get() = procedureRepository.findAll().stream().sorted(ProcedureComparator()).collect(Collectors.toList())

    fun getAllProceduresSortedByCoastFilteredByProcedureDescription(procedureDescription: String): List<Procedure> {
        return procedureRepository.findAll().stream().filter { e: Procedure ->
            e.description!!.uppercase().contains(procedureDescription.uppercase(Locale.getDefault()))
        }.sorted(ProcedureComparator()).collect(Collectors.toList())
    }

    fun findById(Id: Long): Procedure {
        return procedureRepository.findById(Id).get()
    }
}

internal class ProcedureComparator : Comparator<Procedure> {
    override fun compare(o1: Procedure, o2: Procedure): Int {
        return o1.cost.compareTo(o2.cost)
    }
}

