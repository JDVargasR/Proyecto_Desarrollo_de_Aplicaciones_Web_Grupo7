package com.Proyecto_Grupo7.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorPassword {
        public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordEncriptado = encoder.encode("Josue123."); // Cambiá aquí tu contraseña
        System.out.println("🔐 Password encriptado: " + passwordEncriptado);
    }
    
}
