package dev.alexandreyoshimatsu.kotlinspring.service

import dev.alexandreyoshimatsu.kotlinspring.model.Usuario
import dev.alexandreyoshimatsu.kotlinspring.repository.UsuarioRepository
import javassist.NotFoundException
import org.springframework.stereotype.Service

@Service
class UsuarioService(private val usuarioRepository: UsuarioRepository, private val notFoundMessage: String = "Usuário nao encontrado!") {

    fun buscarPorId(id: Long): Usuario {
        return usuarioRepository.findById(id).orElseThrow({ NotFoundException(notFoundMessage) })
    }


}
