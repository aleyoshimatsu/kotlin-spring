package dev.alexandreyoshimatsu.kotlinspring.repository

import dev.alexandreyoshimatsu.kotlinspring.model.Curso
import org.springframework.data.jpa.repository.JpaRepository

interface CursoRepository: JpaRepository<Curso, Long>