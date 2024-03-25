package com.ecom.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.models.Product;

@RestController
@RequestMapping("products")
public class ProductController {
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id) {
        return new Product();
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return new  ArrayList<>();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product prod) {
        return new Product();
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }

    @PutMapping("{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return new Product();
    }
}
