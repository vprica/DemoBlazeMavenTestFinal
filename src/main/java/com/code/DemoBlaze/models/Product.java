package com.code.DemoBlaze.models;

public class Product {
    private String name;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public double getPriceAsDouble() {
        String formattedPrice = price.substring(1);
        return Double.parseDouble(formattedPrice);
    }

    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }



}
