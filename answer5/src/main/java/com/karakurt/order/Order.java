package com.karakurt.order;

import com.karakurt.needs.DateOperations;
import com.karakurt.product.Product;
import com.karakurt.product.ProductINF;

import java.time.LocalDate;
import java.util.List;

public class Order implements OrderINF {
    private LocalDate createdDT = DateOperations.createdDT;
    private OrderStatus orderStatus;
    private List<ProductINF> productList;
    public Order() {
        this.orderStatus = OrderStatus.PENDING;
    }
    @Override
    public void addProduct(Product product) {
        productList.add(product);
    }
    @Override
    public OrderStatus ongoing(OrderCase orderCase) {
        if(this.orderStatus == null)
            this.orderStatus = OrderStatus.PENDING;

        this.orderStatus = orderStatus.nextStatus(orderCase);

        return this.orderStatus;
    }
    @Override
    public LocalDate getCreatedDT(){
        return createdDT;
    }
    @Override
    public void setCreatedDT(LocalDate createdDT){
        this.createdDT = createdDT;
    }
    @Override
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    @Override
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    @Override
    public List<ProductINF> getProductList() {
        return productList;
    }
    @Override
    public void setProductList(List<ProductINF> productList) {
        this.productList = productList;
    }
    @Override
    public String toString() {
        return "Order{" +
                ", orderStatus=" + this.orderStatus +
                ", products=" + this.productList +
                ", createdDateTime=" + this.createdDT +
                '}';
    }
}
