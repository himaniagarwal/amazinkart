package com.amazinkart.service;

import com.amazinkart.models.DiscountedProduct;
import com.amazinkart.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface DiscountService {

    DiscountedProduct applyDiscount(Product product);
}
