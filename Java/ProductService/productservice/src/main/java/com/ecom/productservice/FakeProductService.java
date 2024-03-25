package com.ecom.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ecom.dtos.FakeProductDto;
import com.ecom.models.Category;
import com.ecom.models.Product;

@Service
public class FakeProductService implements ProductService {
    private RestTemplate restTemplate;
    final private String urlStr = "https://fakestoreapi.com/products/";

    FakeProductService(RestTemplate rTemplate) {
        this.restTemplate = rTemplate;
    }

    private Product convertDtoToProductObject(FakeProductDto dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setTitle(dto.getTitle());
        product.setDescription(dto.getDescription());
        product.setImage(dto.getImage());

        Category category = new Category();
        category.setTitle(dto.getCategory());
        return product;
    }

    private ArrayList<Product> convertDtoArrayToProductsList(FakeProductDto[] productDto) {
        ArrayList<Product> products = new ArrayList<>();
        for(var prod: productDto) {
            products.add(convertDtoToProductObject(prod));
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) {
        FakeProductDto resp = restTemplate.getForObject(urlStr + id, FakeProductDto.class);
        if (resp == null) {
            return null;
        }
        return convertDtoToProductObject(resp);
    }

    @Override
    public List<Product> getAllProducts(){
        ResponseEntity<FakeProductDto[]> resp = restTemplate.getForEntity(urlStr, FakeProductDto[].class);
        return convertDtoArrayToProductsList(resp.getBody());
    }

    @Override
    public Product updateProduct() {
        return null;
    }

    @Override
    public Product replaceProduct() {
        return null;
    }

    @Override
    public Product createProduct() {
        return null;
    }

    @Override
    public void deleteProduct() {

    }
}
