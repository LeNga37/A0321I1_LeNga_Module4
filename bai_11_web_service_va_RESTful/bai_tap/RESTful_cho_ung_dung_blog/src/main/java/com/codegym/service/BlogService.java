package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog getBlogById(Long id);

    void save(Blog blog);

    void deleteBlogById(Long id);

    List<Blog> findAllByCategory(Category category);
    public Page<Blog> findByTitleContaining(String name,Pageable pageable);

}
