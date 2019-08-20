package com.amazinkart;

import com.amazinkart.models.DiscountedProduct;
import com.amazinkart.models.ExchangeRate;
import com.amazinkart.models.Product;
import com.amazinkart.service.DiscountService;
import com.amazinkart.service.ExchangeService;
import com.amazinkart.service.ProductService;
import com.amazinkart.service.PromotionADiscountService;
import com.amazinkart.service.PromotionBDiscountService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    private static DiscountService getDiscountService(String promotionSet) {
        if (promotionSet!=null && promotionSet.equals("promotionSetA")) {
            return new PromotionADiscountService();
        } else {
            return new PromotionBDiscountService();
        }
    }

    public static void main(String[] args) throws IOException {
        RestClient restClient = new RestClient();
        String exchangeRateDetails = restClient.getDetails("https://api.exchangeratesapi.io/latest");
        String productDetails = restClient.getDetails("https://api.jsonbin.io/b/5d31a1c4536bb970455172ca/latest");
        String promotionSet = args[0];

        ProductService productService = new ProductService();
        List<Product> productList = productService.getProductList(productDetails);

        ExchangeService exchangeService = new ExchangeService();
        ExchangeRate exchangeRate = exchangeService.getExchangeRate(exchangeRateDetails);
        List<Product> productListInINR = exchangeService.convertIntoINR(productList, exchangeRate);

        DiscountService discountService = getDiscountService(promotionSet);
        List<DiscountedProduct> discountedProducts = productListInINR.stream()
                .map(discountService::applyDiscount)
                .collect(Collectors.toList());

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.writeValue(new File("/Users/ahimani/amazinkart/src/main/resources/output/output.json"), discountedProducts);
    }
}