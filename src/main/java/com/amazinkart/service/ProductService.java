package com.amazinkart.service;

import com.amazinkart.models.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class ProductService {
    private ObjectMapper objectMapper;

    public ProductService() {
        objectMapper = new ObjectMapper();
    }

    public List<Product> getProductList(String productDetails) throws IOException {
        return objectMapper.readValue(productDetails, new TypeReference<List<Product>>() {});
    }
}
