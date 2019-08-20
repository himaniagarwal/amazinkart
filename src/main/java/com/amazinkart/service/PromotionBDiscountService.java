package com.amazinkart.service;

import com.amazinkart.models.Discount;
import com.amazinkart.models.DiscountedProduct;
import com.amazinkart.models.Product;

public class PromotionBDiscountService implements DiscountService {
    @Override
    public DiscountedProduct applyDiscount(Product product) {
        double discountAmount = 0.0;
        String discountTag = "";
        Integer productPrice = product.getPrice();
        if(product.getArrival()!= null && product.getArrival().equalsIgnoreCase("new")){
            discountAmount = productPrice * 0.07;
            discountTag = "get 7% off";
        }
        if(product.getInventory() > 20){
            discountAmount = productPrice * 0.12;
            discountTag = "get 12% off";
        }

        if(discountAmount == 0.0 && discountTag.isEmpty() && productPrice > 1000){
            discountAmount = productPrice * 0.02;
            discountTag = "get 2% off";
        }
        Discount discount = new Discount(String.format("%.2f", discountAmount), discountTag);
        return new DiscountedProduct(product, discount);
    }
}
