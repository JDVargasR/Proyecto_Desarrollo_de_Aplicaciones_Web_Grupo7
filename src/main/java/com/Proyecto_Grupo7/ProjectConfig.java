package com.Proyecto_Grupo7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.Proyecto_Grupo7.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class ProjectConfig {

    private final UserDetailsServiceImpl userDetailsService;

    public ProjectConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login", 
                                "/registro/**", 
                                "/css/**", 
                                "/js/**",
                                "/Login/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/Login/Login")                    // Página personalizada
                        .loginProcessingUrl("/Login/Login")          // Donde se hace POST
                        .defaultSuccessUrl("/index", true)           // A dónde va tras login correcto
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/Login/Login?logout")
                        .permitAll()
                )
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {

        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }
}
