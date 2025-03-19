/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Grupo7.service.impl;

import com.Proyecto_Grupo7.dao.BlogDao;
import com.Proyecto_Grupo7.domain.Blog;
import com.Proyecto_Grupo7.service.BlogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author gmora
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    @Override
    @Transactional(readOnly = true)
    public List<Blog> getBlog(boolean activos) {
        var lista = blogDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Blog getBlog(Blog blog) {
        return blogDao.findById(blog.getIdBlog()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Blog blog) {
        blogDao.save(blog);
    }

    @Override
    @Transactional
    public void delete(Blog blog) {
        blogDao.delete(blog);
    }
}
