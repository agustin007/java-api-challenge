package com.hackerrank.sample.controller;

import com.hackerrank.sample.model.Product;
import com.hackerrank.sample.service.ProductService;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    @ResponseBody
    public String home() {
        return "API de Productos - Spring Boot";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewProduct(@RequestBody @Valid Product product) {
        productService.createProduct(product);
    }

    @RequestMapping(value = "/erase", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteProductById(@PathVariable Long id) {
        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }
}
