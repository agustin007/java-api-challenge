package com.hackerrank.sample.repository;

import com.hackerrank.sample.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    void deleteById(Long id);
}
