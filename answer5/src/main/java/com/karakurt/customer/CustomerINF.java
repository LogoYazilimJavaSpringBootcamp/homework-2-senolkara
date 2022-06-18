package com.karakurt.customer;

import com.karakurt.address.AddressINF;
import com.karakurt.needs.DateOperations;
import com.karakurt.order.OrderINF;

import java.util.Set;

public interface CustomerINF extends DateOperations {
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
    String getEmail();
    void setEmail(String email);
    Set<AddressINF> getAddresses();
    void setAddresses(Set<AddressINF> addresses);
    OrderINF getOrder();
    void setOrder(OrderINF order);
}
