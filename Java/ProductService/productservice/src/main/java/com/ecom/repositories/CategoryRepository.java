package com.ecom.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ecom.models.Category;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category save(Category category);
    Optional<Category> findByTitle(String title);
} 
