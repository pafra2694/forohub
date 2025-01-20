package com.pafradev.foroHub.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long idAutor,
        String titulo,
        String mensaje,
        String curso,
        LocalDateTime fechaCreacion
) {
}
