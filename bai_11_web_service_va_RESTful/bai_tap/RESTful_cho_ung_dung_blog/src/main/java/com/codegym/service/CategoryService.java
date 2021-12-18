package com.codegym.service;

import com.codegym.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category getCategoryById(int id);

    void save(Category category);

    void deleteCategoryById(int id);

}
