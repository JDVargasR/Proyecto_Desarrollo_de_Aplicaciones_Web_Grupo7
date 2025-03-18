/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto_Grupo7.dao;

import com.Proyecto_Grupo7.domain.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author gmora
 */
public interface BlogDao extends JpaRepository <Blog, Long>{
    
}
