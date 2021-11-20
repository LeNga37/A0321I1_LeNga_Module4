package codegym.service;

import codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(int productId);

    void update(int productId, Product product);

    void remove(int productId);

}
