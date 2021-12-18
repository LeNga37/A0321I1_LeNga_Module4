package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    //    Iterable<Blog> findAllByCategory(Category category);
    List<Blog> findAllByCategory(Category category);

    Page<Blog> findByTitleContaining(String name, Pageable pageable);
}
