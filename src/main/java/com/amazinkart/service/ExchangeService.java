package com.amazinkart.service;

import com.amazinkart.models.ExchangeRate;
import com.amazinkart.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ExchangeService {
    private ObjectMapper objectMapper;

    public ExchangeService() {
        objectMapper = new ObjectMapper();
    }

    public List<Product> convertIntoINR(List<Product> productList, ExchangeRate exchangeRate) {
        return productList.stream().map(product -> {
            if (!product.getCurrency().equals("INR")) {
                product.setPrice((int) ((product.getPrice()/exchangeRate.getRates().get(product.getCurrency())) * exchangeRate.getRates().get("INR")));
                product.setCurrency("INR");
            }
            return product;
        }).collect(Collectors.toList());
    }

    public ExchangeRate getExchangeRate(String exchangeRateDetails) throws IOException {
        return objectMapper.readValue(exchangeRateDetails, ExchangeRate.class);
    }
}
