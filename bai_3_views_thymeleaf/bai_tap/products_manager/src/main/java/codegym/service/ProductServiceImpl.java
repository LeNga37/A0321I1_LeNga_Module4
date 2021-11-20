package codegym.service;

import codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> productMap;
    static {
        productMap =new HashMap<>();
        productMap.put(1, new Product(1, "iphone5", 2000000, "new", "USA"));
        productMap.put(2, new Product(2, "iphone6", 3000000, "new", "Uk"));
        productMap.put(3, new Product(3, "iphone7", 4000000, "new", "USA"));
        productMap.put(4, new Product(4, "iphone8", 5000000, "new", "Japan"));
        productMap.put(5, new Product(5, "iphone9", 6000000, "new", "USA"));
        productMap.put(6, new Product(6, "iphone10", 7000000, "new", "Japan"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getProductId(),product);
    }

    @Override
    public Product findById(int productId) {
        return productMap.get(productId);
    }

    @Override
    public void update(int productId, Product product) {
        productMap.put(productId,product);
    }

    @Override
    public void remove(int productId) {
        productMap.remove(productId);
    }
}
