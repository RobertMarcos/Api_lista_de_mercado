package com.example.lista_mecados.repositori;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.lista_mecados.models.lista_model;


@Repository
public interface product extends JpaRepository<lista_model,UUID> {
    
}
