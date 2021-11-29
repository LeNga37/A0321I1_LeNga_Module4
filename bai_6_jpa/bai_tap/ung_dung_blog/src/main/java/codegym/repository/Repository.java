package codegym.repository;

import codegym.model.Blog;

import java.util.List;

public interface Repository<Blog> {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog model);

    void remove(Long id);

    void update(Blog blog);

}
