package com.karakurt.order;

import com.karakurt.needs.DateOperations;
import com.karakurt.product.Product;
import com.karakurt.product.ProductINF;

import java.util.List;

public interface OrderINF extends DateOperations {
    List<ProductINF> getProductList();
    void setProductList(List<ProductINF> productList);
    OrderStatus getOrderStatus();
    void setOrderStatus(OrderStatus orderStatus);
    void addProduct(Product product);
    OrderStatus ongoing(OrderCase orderCase);
}
