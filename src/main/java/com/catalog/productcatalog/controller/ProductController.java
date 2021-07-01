package com.catalog.productcatalog.controller;

import com.catalog.productcatalog.model.Product;
import com.catalog.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Product createProduct(@RequestBody Product pc) {
        return productRepository.save(pc);
    }

    @GetMapping("/{id}")
    public Optional<Product> getByIdProduct(@PathVariable("id") Long id) {
        return productRepository.findById(id);
    }

    @GetMapping
    public List<Product> getAllProduct() {
        return (List<Product>) productRepository.findAll();
    }
}
