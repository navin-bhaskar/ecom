package com.ecom.productservice;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecom.exceptions.InvalidProductIdException;
import com.ecom.models.Category;
import com.ecom.models.Product;
import com.ecom.repositories.CategoryRepository;
import com.ecom.repositories.ProductRepository;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        // String categoryTitle = product.getCategory().getTitle();
        // Optional<Category> category =  categoryRepository.findByTitle(categoryTitle);
        // if(category.isEmpty()) {
        //     Category cat = categoryRepository.save(product.getCategory());
        //     product.setCategory(cat);
        // } else {
        //     product.setCategory(category.get());
        // }
        productRepository.save(product);
        return product;
    }

    @Override
    public Product getProductById(Long id) throws InvalidProductIdException {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new InvalidProductIdException(id);
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts;
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
