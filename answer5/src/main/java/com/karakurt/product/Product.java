package com.karakurt.product;

public class Product implements ProductINF {
    private String name;
    private Double price;
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public Double getPrice() {
        return price;
    }
    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
}
