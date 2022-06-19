package com.karakurt.customer;

import com.karakurt.needs.DateOperations;
import com.karakurt.needs.UserOperations;
import com.karakurt.order.*;
import com.karakurt.user.UserManager;

import java.time.LocalDate;
import java.util.*;

public class CustomerManager extends UserManager {
    LocalDate registerDate = DateOperations.registerDate;
    private List<CustomerINF> customers;
    public List<CustomerINF> getCustomerList() {
        List<CustomerINF> customerList = new ArrayList<>();
        Map<String,String> randomUsers = UserOperations.randomUsers;
        OrderCase orderCase = new OrderCase();
        orderCase.setType(OrderCaseType.PENDING);
        OrderManager orderManager = new OrderManager();
        randomUsers.forEach((username,addr) -> {
            List<OrderINF> orderList = orderManager.getOrderList();
            int randomKey = new Random().nextInt(orderList.size() - 1);
            OrderINF order = orderManager.getOneOrder(orderList,randomKey);
            CustomerINF customer = this.createCustomer(username,addr,order,registerDate);

            customerList.add(customer);
            OrderStatus orderStatus = order.ongoing(orderCase);
            orderManager.changeOrderCaseType(orderCase, orderStatus, order);
        });
        this.customers = customerList;
        return this.customers;
    }
    private CustomerINF createCustomer(String username, String addr, OrderINF order, LocalDate createdDT){
        return CustomerFactory.createCustomer(username, addr, order, createdDT);
    }
}
