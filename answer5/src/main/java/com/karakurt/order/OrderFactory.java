package com.karakurt.order;

import com.karakurt.product.ProductManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OrderFactory {
    public static List<OrderINF> createOrder(){
        List<OrderINF> orderList = new ArrayList<>();
        int randomOrderNumber = new Random().nextInt(10) + 3;
        ProductManager productManager = new ProductManager();
        for (int i = 0; i < randomOrderNumber; i++) {
            OrderINF order = new Order();
            order.setProductList(productManager.getProductList(randomOrderNumber));
            LocalDate localDate = LocalDate.now();
            order.setCreatedDT(localDate);
            orderList.add(order);
        }
        return orderList;
    }
}
