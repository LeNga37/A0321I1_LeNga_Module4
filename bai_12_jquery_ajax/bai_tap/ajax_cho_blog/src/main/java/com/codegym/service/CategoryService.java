package com.codegym.service;

import com.codegym.model.Category;

public interface CategoryService {
    Iterable<Category> findAll();

    Category getCategoryById(int id);

    void save(Category category);

    void deleteCategoryById(int id);

}
