package com.hackerrank.sample.service;

import com.hackerrank.sample.model.Product;
import java.util.List;

public interface ProductService {
    void deleteAllProducts();
    void deleteProductById(Long id);
    void createProduct(Product product);
    Product getProductById(Long id);
    List<Product> getAllProducts();
}
