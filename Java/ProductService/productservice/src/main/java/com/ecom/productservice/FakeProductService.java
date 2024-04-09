package com.ecom.productservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.ecom.dtos.FakeProductDto;
import com.ecom.dtos.FakeProdutcPostDto;
import com.ecom.dtos.ProductDto;
import com.ecom.models.Category;
import com.ecom.models.Product;
import com.ecom.exceptions.InvalidProductIdException;

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
    public Product getProductById(Long id) throws InvalidProductIdException{
        FakeProductDto resp = restTemplate.getForObject(urlStr + id, FakeProductDto.class);
        if (resp == null) {
            throw new InvalidProductIdException(id);
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
    public Product replaceProduct(Long id, Product product) {
        FakeProductDto productDto = new FakeProductDto();
        productDto.setCategory(product.getTitle());
        productDto.setId(id);
        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice());

        var responseType = ProductDto.class;
        RequestCallback requestCallback = restTemplate.httpEntityCallback(productDto, responseType);
        HttpMessageConverterExtractor<ProductDto> responseExtractor = new HttpMessageConverterExtractor(
            responseType, restTemplate.getMessageConverters());

        ProductDto resp = restTemplate.execute(urlStr + id, HttpMethod.PUT, requestCallback, responseExtractor);
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        FakeProdutcPostDto productDto = new FakeProdutcPostDto();
        productDto.setTitle(product.getTitle());
        productDto.setImage(product.getImage());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());
        productDto.setCategory(product.getCategory().getTitle());

        FakeProductDto resp = restTemplate.postForObject(urlStr, productDto, FakeProductDto.class);
        return convertDtoToProductObject(resp);

    }

    @Override
    public void deleteProduct() {

    }
}
