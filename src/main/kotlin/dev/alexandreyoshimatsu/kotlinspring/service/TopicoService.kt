package dev.alexandreyoshimatsu.kotlinspring.service

import dev.alexandreyoshimatsu.kotlinspring.dto.AtualizacaoTopicoForm
import dev.alexandreyoshimatsu.kotlinspring.dto.NovoTopicoForm
import dev.alexandreyoshimatsu.kotlinspring.dto.TopicoView
import dev.alexandreyoshimatsu.kotlinspring.exception.NotFoundException
import dev.alexandreyoshimatsu.kotlinspring.mapper.TopicoFormMapper
import dev.alexandreyoshimatsu.kotlinspring.mapper.TopicoViewMapper
import dev.alexandreyoshimatsu.kotlinspring.repository.TopicoRepository
import org.springframework.stereotype.Service
import java.util.stream.Collectors

@Service
class TopicoService(
        private val topicoRepository: TopicoRepository,
        private val topicoViewMapper: TopicoViewMapper,
        private val topicoFormMapper: TopicoFormMapper,
        private val notFoundMessage: String = "Topico nao encontrado!"
) {

    fun listar(): List<TopicoView> {
        return topicoRepository.findAll()
                .stream()
                .map { t ->
                    topicoViewMapper.map(t)
                }.collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicoRepository.findById(id).orElseThrow { NotFoundException(notFoundMessage) }
        return topicoViewMapper.map(topico)
    }

    fun cadastrar(form: NovoTopicoForm): TopicoView {
        var topico = topicoFormMapper.map(form)
        topico = topicoRepository.saveAndFlush(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        var topico = topicoRepository.findById(form.id).orElseThrow { NotFoundException(notFoundMessage) }
        topico.titulo = form.titulo
        topico.mensagem = form.mensagem

        topico = topicoRepository.saveAndFlush(topico)

        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        topicoRepository.deleteById(id)
    }

}