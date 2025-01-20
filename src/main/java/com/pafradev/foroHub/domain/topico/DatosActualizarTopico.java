package com.pafradev.foroHub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
        Long idAutor,
        String titulo,
        String mensaje,
        String curso,
        Estatus estatus
) {
}
