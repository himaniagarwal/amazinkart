package com.amazinkart.service;

import com.amazinkart.models.Discount;
import com.amazinkart.models.DiscountedProduct;
import com.amazinkart.models.Product;

public class PromotionADiscountService implements DiscountService {

    @Override
    public DiscountedProduct applyDiscount(Product product) {
        double discountAmount = 0;
        String discountTag = "";
        Integer productPrice = product.getPrice();
        if(product.getRating() == 2){
            discountAmount = productPrice * 0.04;
            discountTag = "get 4% off";
        }
        if(product.getOrigin().equalsIgnoreCase("Africa")){
            discountAmount = productPrice * 0.07;
            discountTag = "get 7% off";

        }
        if(product.getRating() < 2){
            discountAmount = productPrice * 0.08;
            discountTag = "get 8% off";
        }

        double flatDiscountAmount = 0;
        String flatDiscountTag ="";

        if(productPrice >= 500 && categoryInElectronicsOrFurniture(product)){
            flatDiscountAmount = 100;
            flatDiscountTag = "get Rs 100 off";
        }

        double finalDiscount = discountAmount > flatDiscountAmount ? discountAmount: flatDiscountAmount;
        String finalDiscountTag = discountAmount > flatDiscountAmount ? discountTag: flatDiscountTag;

        if(finalDiscount == 0.0 && finalDiscountTag.equals("") && productPrice > 1000){
            finalDiscount = productPrice * 0.02;
            finalDiscountTag = "get 2% off";
        }

        Discount discount = new Discount(String.format("%.2f", finalDiscount), finalDiscountTag);
        return new DiscountedProduct(product, discount);
    }

    private boolean categoryInElectronicsOrFurniture(Product product) {
        return product.getCategory().equalsIgnoreCase("electronics") || product.getCategory().equalsIgnoreCase("furnishing");
    }
}
