package com.Proyecto_Grupo7.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Proyecto_Grupo7.domain.Usuario; 

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
