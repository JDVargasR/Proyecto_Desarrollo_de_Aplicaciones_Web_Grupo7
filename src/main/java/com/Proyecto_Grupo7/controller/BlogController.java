package com.Proyecto_Grupo7.controller;

import com.Proyecto_Grupo7.domain.Blog;
import com.Proyecto_Grupo7.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/templates/blog") // 👈 más directo y ordenado
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public String listado(Model model) {
        var lista = blogService.getBlog(true); // 👈 activos = true
        model.addAttribute("blog", lista);
        model.addAttribute("totalBlog", lista.size());
        return "Blog/Blog"; // coincide con /templates/Blog/Blog.html
    }

    @PostMapping("/agregar")
    @PreAuthorize("hasRole('ADMIN')")
    public String agregarBlog(@RequestParam String titulo,
                              @RequestParam String descripcion,
                              @RequestParam String contenido,
                              @RequestParam String imagenUrl) {
        Blog nuevo = new Blog();
        nuevo.setTitulo(titulo);
        nuevo.setDescripcion(descripcion);
        nuevo.setContenido(contenido);
        nuevo.setImagenUrl(imagenUrl);
        nuevo.setActivo(true);
        blogService.save(nuevo);
        return "redirect:/templates/blog";
    }

    @GetMapping("/eliminar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminar(@PathVariable Long id) {
        Blog blog = new Blog();
        blog.setIdBlog(id);
        blogService.delete(blog);
        return "redirect:/templates/blog";
    }

    @GetMapping("/editar/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String editarBlog(@PathVariable("id") Long id, Model model) {
        Blog blog = new Blog();
        blog.setIdBlog(id);
        var blogEncontrado = blogService.getBlog(blog);
        var lista = blogService.getBlog(true);
    
        model.addAttribute("blogEditado", blogEncontrado); // este es el que se está editando
        model.addAttribute("blog", lista); // todos los blogs
    
        return "Blog/Blog";
    }

@PostMapping("/editar")
@PreAuthorize("hasRole('ADMIN')")
public String guardarEdicion(@ModelAttribute Blog blog) {
    blog.setActivo(true); // para que no se pierda el estado
    blogService.save(blog);
    return "redirect:/templates/blog";
}

    
}
