package com.karakurt.product;

public class ProductFactory {
    public static ProductINF createProduct(String name, Double price){
        ProductINF product = new Product();
        product.setName(name);
        product.setPrice(price);
        return product;
    }
}
