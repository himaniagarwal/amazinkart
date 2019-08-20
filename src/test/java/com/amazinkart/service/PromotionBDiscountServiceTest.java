package com.amazinkart.service;

import com.amazinkart.models.DiscountedProduct;
import com.amazinkart.models.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PromotionBDiscountServiceTest {

    PromotionBDiscountService promotionBDiscountService = new PromotionBDiscountService();

    @Test
    public void shouldGiveDiscountOf7PercentForProductA() {
        Product product = getProductA();
        DiscountedProduct discountedProduct = promotionBDiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice() * 0.07));
        String expectedDiscountTag = "get 7% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    @Test
    public void shouldGiveDiscountOf12PercentForProductB() {
        Product product = getProductB();
        DiscountedProduct discountedProduct = promotionBDiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice() * 0.12));
        String expectedDiscountTag = "get 12% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    @Test
    public void shouldGiveDiscountOf2PercentForProductC() {
        Product product = getProductC();
        DiscountedProduct discountedProduct = promotionBDiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice() * 0.02));
        String expectedDiscountTag = "get 2% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    private Product getProductA() {
        Product product = new Product();
        product.setArrival("new");
        product.setInventory(1);
        product.setPrice(1200);
        return product;
    }

    private Product getProductB() {
        Product product = new Product();
        product.setArrival("new");
        product.setInventory(100);
        product.setPrice(1200);
        return product;
    }

    private Product getProductC() {
        Product product = new Product();
        product.setInventory(2);
        product.setPrice(1200);
        return product;
    }

}