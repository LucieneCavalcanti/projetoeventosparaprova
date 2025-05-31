package com.revisao.projetoexemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revisao.projetoexemplo.entity.EventoEntity;

@Repository
public interface EventoRepository extends 
JpaRepository<EventoEntity, Integer>{
    
}
