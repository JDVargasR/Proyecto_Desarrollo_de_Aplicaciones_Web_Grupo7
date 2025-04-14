package com.Proyecto_Grupo7.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Proyecto_Grupo7.dao.UsuarioRepository;
import com.Proyecto_Grupo7.domain.Rol;
import com.Proyecto_Grupo7.domain.Usuario;

@Controller
public class LoginController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/Login/Login")
    public String mostrarLogin() {
        return "Login/Login";
    }

    @PostMapping("/registro/crearUsuario")
    public String crearUsuario(@RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String username,
            @RequestParam String password) {

        // Verificar si el usuario ya existe
        if (usuarioRepository.findByUsername(username).isPresent()) {
            return "redirect:/Login/Login?errorUsuarioExiste";
        }

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setCorreo(correo);
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password));

        Rol rolUser = new Rol();
        rolUser.setId(1L);
        rolUser.setNombre("USER");

        usuario.setRoles(List.of(rolUser));
        usuarioRepository.save(usuario);

        return "redirect:/Login/Login?registroExitoso";
    }

}
