package com.karakurt.customer;

import com.karakurt.address.AddressINF;
import com.karakurt.needs.DateOperations;
import com.karakurt.order.OrderINF;

import java.time.LocalDate;

public class Customer implements CustomerINF {
    private String firstName;
    private String lastName;
    private String email;
    private AddressINF address;
    private OrderINF order;
    private LocalDate createdDT = DateOperations.createdDT;
    @Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public AddressINF getAddress() {
        return address;
    }
    @Override
    public void setAddress(AddressINF address) {
        this.address = address;
    }
    @Override
    public OrderINF getOrder() {
        return order;
    }
    @Override
    public void setOrder(OrderINF order) {
        this.order = order;
    }
    @Override
    public LocalDate getCreatedDT() {
        return createdDT;
    }
    @Override
    public void setCreatedDT(LocalDate createdDT) {
        this.createdDT = createdDT;
    }
    @Override
    public String toString() {
        return "Customer{" +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                ", address='" + this.address + '\'' +
                ", order='" + this.order + '\'' +
                '}';
    }
}
