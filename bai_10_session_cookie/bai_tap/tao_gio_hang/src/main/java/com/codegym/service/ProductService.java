package com.codegym.service;

import com.codegym.model.Product;

public interface ProductService {
    Iterable<Product> findAll();

    Product findById(int id);

    void save(Product customer);

    void remove(int id);
}
