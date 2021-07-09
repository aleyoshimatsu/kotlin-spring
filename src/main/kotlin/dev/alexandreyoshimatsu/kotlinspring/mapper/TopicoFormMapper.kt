package dev.alexandreyoshimatsu.kotlinspring.mapper

import dev.alexandreyoshimatsu.kotlinspring.dto.NovoTopicoForm
import dev.alexandreyoshimatsu.kotlinspring.model.Topico
import dev.alexandreyoshimatsu.kotlinspring.service.CursoService
import dev.alexandreyoshimatsu.kotlinspring.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
        private val cursoService: CursoService,
        private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
                titulo = t.titulo,
                mensagem = t.mensagem,
                curso = cursoService.buscarPorId(t.idCurso),
                autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
