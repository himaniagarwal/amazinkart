package com.amazinkart.service;

import com.amazinkart.models.Product;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ProductServiceTest {

    private ProductService productService = new ProductService();
    @Test
    public void shouldReturnProductListFromAGivenString() throws IOException {
        String productDetails = "[ {\"product\": \"XTP mobile\", \"origin\": \"Asia\", \"price\": 2500, \"currency\": \"INR\", \"rating\": 3.8, \"inventory\": 10, \"category\": \"electronics\"}, {\"product\": \"Maximize mobile\", \"origin\": \"Asia\", \"price\": 4500, \"currency\": \"INR\", \"rating\": 1.8, \"inventory\": 5, \"category\": \"electronics\"} ]";
        List<Product> productList = productService.getProductList(productDetails);
        assertThat(productList.size(), is(2));
        Product product1 = productList.get(0);
        assertThat(product1.getProduct(), is("XTP mobile"));
        assertThat(product1.getOrigin(), is("Asia"));
        assertThat(product1.getPrice(), is(2500));
        assertThat(product1.getCurrency(), is("INR"));
        assertThat(product1.getRating(), is(3.8));
        assertThat(product1.getInventory(), is(10));
        assertThat(product1.getCategory(), is("electronics"));

        Product product2 = productList.get(1);
        assertThat(product2.getProduct(), is("Maximize mobile"));
        assertThat(product2.getOrigin(), is("Asia"));
        assertThat(product2.getPrice(), is(4500));
        assertThat(product2.getCurrency(), is("INR"));
        assertThat(product2.getRating(), is(1.8));
        assertThat(product2.getInventory(), is(5));
        assertThat(product2.getCategory(), is("electronics"));

    }

}