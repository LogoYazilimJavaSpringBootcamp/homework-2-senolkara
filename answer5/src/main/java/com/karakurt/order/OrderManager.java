package com.karakurt.order;

import java.util.List;

public class OrderManager {
    private List<OrderINF> orders;
    public List<OrderINF> getOrderList() {
        this.orders = OrderFactory.createOrder();
        return this.orders;
    }
    public OrderINF getOneOrder(List<OrderINF> orderList, int index){
        return orderList.get(index);
    }
    public void changeOrderCaseType(OrderCase orderCase, OrderStatus orderStatus, OrderINF order){
        orderCase.setType(OrderCaseType.CREATED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.ORDERED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.SHIPPED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.PURCHASED);
        order.setOrderStatus(orderStatus);
        orderCase.setType(OrderCaseType.PENDING);
    }
}
