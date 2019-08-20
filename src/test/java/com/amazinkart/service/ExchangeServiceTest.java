package com.amazinkart.service;

import com.amazinkart.models.ExchangeRate;
import com.amazinkart.models.Product;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ExchangeServiceTest {

    private ExchangeService exchangeService = new ExchangeService();

    @Test
    public void shouldReturnExchangeRateFromAGivenString() throws IOException {
        String exchangeRateDetails = "{\"rates\": {\"CAD\": 1.473, \"HKD\": 8.6863, \"IDR\": 15753.39}, \"base\": \"EUR\", \"date\": \"2019-08-16\"}";
        ExchangeRate exchangeRate = exchangeService.getExchangeRate(exchangeRateDetails);
        assertThat(exchangeRate.getBase(),is("EUR"));
        assertThat(exchangeRate.getDate(), is("2019-08-16"));
        assertThat(exchangeRate.getRates().size(), is(3));
        assertThat(exchangeRate.getRates().get("CAD"), is(1.473));
        assertThat(exchangeRate.getRates().get("HKD"), is(8.6863));
        assertThat(exchangeRate.getRates().get("IDR"), is(15753.39));
    }

    @Test
    public void shouldTransformProductRatesIntoINR() {
        Product product1 = new Product();
        product1.setProduct("Iron");
        product1.setOrigin("AFRICA");
        product1.setPrice(70);
        product1.setCurrency("HKD");
        product1.setRating(2.0);

        Product product2 = new Product();
        product2.setProduct("Ball");
        product2.setOrigin("EUROPE");
        product2.setPrice(20);
        product2.setCurrency("CAD");
        product2.setRating(2.9);

        List<Product> products = new ArrayList<>(List.of(product1, product2));
        List<Product> productsInINR = exchangeService.convertIntoINR(products, getExchangeRate());

        assertThat(productsInINR.size(), is(products.size()));
        assertThat(productsInINR.get(0).getCurrency(), is("INR"));

        Integer expectedPriceForProduct1 = (int)((product1.getPrice()/getExchangeRate().getRates().get(product1.getCurrency())) * getExchangeRate().getRates().get("INR"));
        assertThat(productsInINR.get(0).getPrice(), is(expectedPriceForProduct1));
        Integer expectedPriceForProduct2 = (int)((product2.getPrice()/getExchangeRate().getRates().get(product2.getCurrency())) * getExchangeRate().getRates().get("INR"));
        assertThat(productsInINR.get(1).getPrice(), is(expectedPriceForProduct2));
    }

    private ExchangeRate getExchangeRate() {
        ExchangeRate exchangeRate = new ExchangeRate();
        HashMap<String, Double> rates = new HashMap<>();
        rates.put("CAD", 1.473);
        rates.put("INR", 78.804);
        rates.put("HKD", 8.6863);
        exchangeRate.setRates(rates);
        return exchangeRate;
    }
}