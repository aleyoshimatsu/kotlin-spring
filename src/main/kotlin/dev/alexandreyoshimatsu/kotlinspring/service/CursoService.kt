package dev.alexandreyoshimatsu.kotlinspring.service

import dev.alexandreyoshimatsu.kotlinspring.exception.NotFoundException
import dev.alexandreyoshimatsu.kotlinspring.model.Curso
import dev.alexandreyoshimatsu.kotlinspring.repository.CursoRepository
import org.springframework.stereotype.Service

@Service
class CursoService private constructor(private val cursoRepository: CursoRepository, val notFoundMessage: String = "Curso não encontrado") {

    fun buscarPorId(id: Long): Curso
        = cursoRepository.findById(id).orElseThrow{NotFoundException(notFoundMessage)}

}
