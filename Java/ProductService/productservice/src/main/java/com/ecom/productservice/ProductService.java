package com.ecom.productservice;



import java.util.List;

import com.ecom.exceptions.InvalidProductIdException;
import com.ecom.models.Product;


public interface ProductService {
    public Product getProductById(Long id) throws InvalidProductIdException;
    public List<Product> getAllProducts();
    public Product updateProduct();
    public Product replaceProduct(Long id, Product product);
    public Product createProduct(Product product);
    public void deleteProduct();
}
