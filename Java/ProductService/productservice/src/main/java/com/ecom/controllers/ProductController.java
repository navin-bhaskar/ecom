package com.ecom.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.exceptions.InvalidProductIdException;
import com.ecom.models.Product;
import com.ecom.productservice.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    private ProductService productService;

    ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long id) throws InvalidProductIdException {
        var prod = productService.getProductById(id);
        return new ResponseEntity<>(prod, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        var allProducts = productService.getAllProducts();
        return new ResponseEntity<>(allProducts, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Product> createProduct(@RequestBody Product prod) {
        var createdProduct = productService.createProduct(prod);
        return new ResponseEntity<>(createdProduct, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        var updatedProduct = new Product();
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        var updatedProduct = productService.replaceProduct(id, product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }
}
