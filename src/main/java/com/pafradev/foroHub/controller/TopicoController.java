package com.pafradev.foroHub.controller;


import com.pafradev.foroHub.domain.topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;


    //Registro de un Tópico
    @PostMapping
    public ResponseEntity resgistrarTopico(@RequestBody @Valid DatosRegistroTopico datosTopico, UriComponentsBuilder uriComponentsBuilder){
        Topico topico = topicoRepository.save(new Topico(datosTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(topico.getIdAutor(),topico.getTitulo(),topico.getMensaje(),topico.getCurso(),topico.getFechaCreacion());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    //Listar todos los Tópicos
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(@PageableDefault(size = 5 ,sort = "fechaCreacion")Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }

    //Obtener detalles de un Tópico
    @GetMapping("/{id}")
    public ResponseEntity regresaDatosTopico(@PathVariable Long id){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            Topico topicoEncontrado = topico.get();
            var datosTopico = new DatosListadoTopico(topicoEncontrado);
            return ResponseEntity.ok(datosTopico);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    //Actualizar Tópico
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            Topico topicoEncontrado = topico.get();
            topicoEncontrado.actualizarDatos(datosActualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaActualizarTopico(topicoEncontrado.getIdAutor(), topicoEncontrado.getTitulo(), topicoEncontrado.getMensaje(), topicoEncontrado.getCurso(), topicoEncontrado.getFechaCreacion(), topicoEncontrado.getEstatus()));
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Borrar Tópico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

}
