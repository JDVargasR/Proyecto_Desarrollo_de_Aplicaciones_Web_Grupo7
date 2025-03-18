/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.controller;

import com.Proyecto_Grupo7.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author gmora
 */
@Controller
@RequestMapping("/templates")
public class BlogController {
    
    @Autowired
    private BlogService blogService;
    
    @GetMapping("/blog")
    public String listado(Model model) {
        var lista = blogService.getBlog(false);
        model.addAttribute("blog", lista);
        model.addAttribute("totalBlog", lista.size());
        return "/blog";
    }
}
