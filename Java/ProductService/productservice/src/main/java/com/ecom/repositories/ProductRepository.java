package com.ecom.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecom.models.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findById(Long id);
    // Optional<Product> findByTitleAndDescription(String title);
    // List<Product> findByTitleContaining(String word);
    Product save(Product product);
} 
