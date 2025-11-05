package com.hackerrank.sample.service;

import com.hackerrank.sample.exception.BadResourceRequestException;
import com.hackerrank.sample.exception.NoSuchResourceFoundException;
import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAllInBatch();
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void createProduct(Product product) {
        Optional<Product> existingProduct = productRepository.findById(product.getId());

        if (existingProduct.isPresent()) {
            throw new BadResourceRequestException("Product with same id exists.");
        }

        productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new NoSuchResourceFoundException("No product with given id found.");
        }

        Product foundProduct = product.get();
        calculateDiscountPrice(foundProduct);
        return foundProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = productRepository.findAll();
        products.forEach(this::calculateDiscountPrice);
        return products;
    }

    private void calculateDiscountPrice(Product product) {
        if (product.getPrice() == null) {
            product.setDiscountPrice(null);
            return;
        }

        double discount = 0.0;

        if ("used".equalsIgnoreCase(product.getCondition())) {
            discount = 0.15;
        }

        if ("Electronics".equalsIgnoreCase(product.getCategory())) {
            discount = Math.max(discount, 0.10);
        }

        if (product.getPrice() > 100.0) {
            discount = Math.max(discount, 0.05);
        }

        if (discount > 0) {
            product.setDiscountPrice(product.getPrice() * (1 - discount));
        } else {
            product.setDiscountPrice(product.getPrice());
        }
    }
}
