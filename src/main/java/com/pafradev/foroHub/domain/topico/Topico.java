package com.pafradev.foroHub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Table(name = "topicos")
@Entity(name = "Topico")
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    private Long idAutor;

    private String curso;

    public Topico(){};

    public Topico(DatosRegistroTopico datosTopico) {
        this.titulo = datosTopico.titulo();
        this.mensaje = datosTopico.mensaje();
        this.fechaCreacion = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        this.curso = datosTopico.curso();
        this.idAutor = datosTopico.idAutor();
        this.estatus = Estatus.valueOf("NORESUELTO");
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public String getCurso() {
        return curso;
    }

    public void actualizarDatos(DatosActualizarTopico datosTopico) {
        if(datosTopico.titulo() != null){
            this.titulo = datosTopico.titulo();
        }
        if(datosTopico.mensaje() != null){
            this.mensaje = datosTopico.mensaje();
        }
        if(datosTopico.curso() != null){
            this.curso = datosTopico.curso();
        }
        if(datosTopico.idAutor() != null){
            this.idAutor = datosTopico.idAutor();
        }
        if(datosTopico.estatus() != null){
            try {
                this.estatus = Estatus.valueOf(datosTopico.estatus().toString());
            } catch (IllegalArgumentException e) {
                System.out.println("Valor de estatus no válido: " + datosTopico.estatus().toString());
            }
        }
    }
}
