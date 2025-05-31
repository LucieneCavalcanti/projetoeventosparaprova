package com.revisao.projetoexemplo.controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revisao.projetoexemplo.entity.EventoEntity;
import com.revisao.projetoexemplo.service.EventoService;
import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor //colocando isso não precisa colocar @Autowired no atributo
@RequestMapping(value = "/evento")
public class EventoController {
    private final EventoService EventoService;

    @GetMapping
    public ResponseEntity<List<EventoEntity>> listarTodos() {
        List<EventoEntity> lista = EventoService.listarTodos();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping
    public ResponseEntity<EventoEntity> incluir(@RequestBody 
    EventoEntity Evento) {
        EventoEntity novo = EventoService.incluir(Evento);
        if (novo != null) {
            return new ResponseEntity<>(novo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

     @PutMapping("/{id}")
    public ResponseEntity<EventoEntity> editar(@PathVariable int id, 
    @RequestBody EventoEntity Evento) {
        EventoEntity atualizado = EventoService.editar(id,Evento);
        if (atualizado != null) {
            return new ResponseEntity<>(atualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        EventoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
