package com.karakurt.product;

import java.util.*;

public class ProductManager {
    private List<ProductINF> products;
    public List<ProductINF> getProductList(int randomOrderNumber) {
        List<ProductINF> productList = new ArrayList<>();
        Map<String,Double> randomProducts = this.getRandomProducts();
        randomProducts.forEach((key,value) -> {
            productList.add(this.createProduct(key,value));
        });
        this.products = productList.stream().limit(randomOrderNumber).toList();
        return this.products;
    }
    private Map<String,Double> getRandomProducts(){
        Random random = new Random();
        Map<String,Double> randomProducts = new HashMap<>();
        randomProducts.put("Jeans",random.nextDouble(90) + 20);
        randomProducts.put("Jacket",random.nextDouble(90) + 20);
        randomProducts.put("Poncho",random.nextDouble(90) + 20);
        randomProducts.put("Cravat",random.nextDouble(40) + 5);
        randomProducts.put("Belt",random.nextDouble(65) + 10);
        randomProducts.put("Cheesecake",random.nextDouble(70) + 40);
        randomProducts.put("Burritos",random.nextDouble(90) + 50);
        randomProducts.put("Sandwich",random.nextDouble(30) + 20);
        randomProducts.put("Calzone",random.nextDouble(110) + 80);
        randomProducts.put("Chicken",random.nextDouble(70) + 40);
        randomProducts.put("Asus",random.nextDouble(400) + 200);
        randomProducts.put("Lenovo",random.nextDouble(400) + 200);
        randomProducts.put("Iphone",random.nextDouble(400) + 200);
        randomProducts.put("Samsung",random.nextDouble(400) + 200);
        randomProducts.put("Casper",random.nextDouble(400) + 200);
        return randomProducts;
    }
    private ProductINF createProduct(String name, Double price){
        return ProductFactory.createProduct(name,price);
    }
}
