package com.pafradev.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long idAutor,
        String titulo,
        String mensaje,
        String curso,
        LocalDateTime fechaCreacion,
        Estatus estado
) {
    public DatosListadoTopico(Topico topico){
        this(topico.getIdAutor(), topico.getTitulo(), topico.getMensaje(), topico.getCurso(), topico.getFechaCreacion(), topico.getEstatus());
    }
}
