package com.example.sprdata.service;

import com.example.sprdata.dto.ProductDto;
import com.example.sprdata.model.Product;
import com.example.sprdata.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ObjectMapper objectMapper;

    public ProductDto createProduct(ProductDto productDto) {
        Product product = objectMapper.convertValue(productDto, Product.class);
        productRepository.save(product);
        return productDto;
    }

}
