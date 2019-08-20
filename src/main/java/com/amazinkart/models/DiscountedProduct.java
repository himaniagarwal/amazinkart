package com.amazinkart.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DiscountedProduct extends Product {

    private Discount discount;

    public DiscountedProduct() {
    }

    public DiscountedProduct(Product product, Discount discount) {
        this.setProduct(product.getProduct());
        this.setOrigin(product.getOrigin());
        this.setPrice(product.getPrice());
        this.setCurrency(product.getCurrency());
        this.setRating(product.getRating());
        this.setArrival(product.getArrival());
        this.setInventory(product.getInventory());
        this.setCategory(product.getCategory());
        this.discount = discount;
    }

    public Discount getDiscount() {
        return discount;
    }

}
