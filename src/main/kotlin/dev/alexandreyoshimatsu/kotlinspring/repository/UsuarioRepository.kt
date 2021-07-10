package dev.alexandreyoshimatsu.kotlinspring.repository

import dev.alexandreyoshimatsu.kotlinspring.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository: JpaRepository<Usuario, Long>