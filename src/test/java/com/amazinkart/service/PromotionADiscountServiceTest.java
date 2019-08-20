package com.amazinkart.service;

import com.amazinkart.models.DiscountedProduct;
import com.amazinkart.models.Product;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PromotionADiscountServiceTest {

    private PromotionADiscountService promotionADiscountService = new PromotionADiscountService();

    @Test
    public void shouldGiveDiscountOf4PercentForProductA() {
        Product product = getProductA();
        DiscountedProduct discountedProduct = promotionADiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice() * 0.04));
        String expectedDiscountTag = "get 4% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    @Test
    public void shouldGiveDiscountOf7PercentForProductB() {
        Product product = getProductB();
        DiscountedProduct discountedProduct = promotionADiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice() * 0.07));
        String expectedDiscountTag = "get 7% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    @Test
    public void shouldGiveDiscountOf8PercentForProductC() {
        Product product = getProductC();
        DiscountedProduct discountedProduct = promotionADiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice() * 0.08));
        String expectedDiscountTag = "get 8% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    @Test
    public void shouldGiveDiscountOf100RupeesForProductD() {
        Product product = getProductD();
        DiscountedProduct discountedProduct = promotionADiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",100.0);
        String expectedDiscountTag = "get Rs 100 off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    @Test
    public void shouldGiveDiscountOf2PercentForProductE() {
        Product product = getProductE();
        DiscountedProduct discountedProduct = promotionADiscountService.applyDiscount(product);
        String actualDiscountAmount = discountedProduct.getDiscount().getAmount();
        String actualDiscountTag = discountedProduct.getDiscount().getDiscountTag();
        String expectedDiscount = String.format("%.2f",(product.getPrice().doubleValue()*0.02));
        String expectedDiscountTag = "get 2% off";
        assertThat(actualDiscountAmount, is(expectedDiscount));
        assertThat(actualDiscountTag, is(expectedDiscountTag));
    }

    private Product getProductA() {
        Product product = new Product();
        product.setPrice(100);
        product.setRating(2.0);
        product.setOrigin("Indonesia");
        product.setCategory("home");
        return product;
    }

    private Product getProductB() {
        Product product = new Product();
        product.setPrice(100);
        product.setRating(2.0);
        product.setOrigin("Africa");
        product.setCategory("home");
        return product;
    }

    private Product getProductC() {
        Product product = new Product();
        product.setPrice(100);
        product.setRating(1.0);
        product.setOrigin("Africa");
        product.setCategory("home");
        return product;
    }

    private Product getProductD() {
        Product product = new Product();
        product.setPrice(600);
        product.setRating(1.0);
        product.setOrigin("Africa");
        product.setCategory("electronics");
        return product;
    }

    private Product getProductE() {
        Product product = new Product();
        product.setPrice(1200);
        product.setRating(3.0);
        product.setOrigin("Atlanta");
        product.setCategory("home");
        return product;
    }
}