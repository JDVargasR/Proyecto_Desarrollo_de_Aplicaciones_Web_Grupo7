package com.Proyecto_Grupo7.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Proyecto_Grupo7.dao.UsuarioRepository;
import com.Proyecto_Grupo7.domain.Usuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("🟡 LLEGÓ A UserDetailsServiceImpl CON: " + username);
        System.out.println("🟡 Intentando autenticar: " + username);
    
        Usuario usuario = usuarioRepository.findByUsername(username)
            .orElseThrow(() -> {
                System.out.println("🔴 Usuario no encontrado en base de datos.");
                return new UsernameNotFoundException("Usuario no encontrado");
            });
    
        System.out.println("🟢 Usuario encontrado: " + usuario.getUsername());
        System.out.println("🔐 Password en BD (encriptado): " + usuario.getPassword());
    
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
            .map(rol -> {
                String authority = "ROLE_" + rol.getNombre();
                System.out.println("🔵 Rol asignado: " + authority);
                return new SimpleGrantedAuthority(authority);
            })
            .collect(Collectors.toList());
    
        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }

    
    
}
