package com.revisao.projetoexemplo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revisao.projetoexemplo.entity.EventoEntity;
import com.revisao.projetoexemplo.repository.EventoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventoService {
    @Autowired
    private final EventoRepository EventoRepository;

    public EventoEntity incluir(EventoEntity Evento) {
        return EventoRepository.save(Evento);
    }
    
    public EventoEntity editar(int id, EventoEntity Evento) {
        // Verifique se a Evento existe
        Optional<EventoEntity> EventoExistente = 
        EventoRepository.findById(id);
        
        if (EventoExistente.isPresent()) {
            // Atualiza a Evento
            EventoEntity EventoAtualizada = EventoExistente.get();
            EventoAtualizada.setNome(Evento.getNome());  // Atualiza os campos necessários
            EventoAtualizada.setData(Evento.getData());  // Atualiza os campos necessários
            EventoAtualizada.setPatrocinios(Evento.getPatrocinios());  // Atualiza os campos necessários
            return EventoRepository.save(EventoAtualizada);  // Salva a Evento atualizada
        } else {
            // Caso a Evento não exista, retorna null
            return null;
        }
    }
    public List<EventoEntity> listarTodos() {
        return EventoRepository.findAll();
    }
    public void excluir(Integer id) {
        EventoRepository.deleteById(id);
    }
}

