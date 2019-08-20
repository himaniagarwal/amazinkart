package com.amazinkart.models;

public class Discount {

    private String amount;
    private String discountTag;

    public Discount() {
    }

    public Discount(String amount, String discountTag) {
        this.amount = amount;
        this.discountTag = discountTag;
    }

    public String getAmount() {
        return amount;
    }

    public String getDiscountTag() {
        return discountTag;
    }

}
