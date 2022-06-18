package com.karakurt.customer;

import com.karakurt.address.AddressINF;
import com.karakurt.needs.DateOperations;
import com.karakurt.order.OrderINF;

import java.time.LocalDate;
import java.util.Set;

public class Customer implements CustomerINF {
    private String firstName;
    private String lastName;
    private String email;
    private Set<AddressINF> addresses;
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
    public Set<AddressINF> getAddresses() {
        return addresses;
    }
    @Override
    public void setAddresses(Set<AddressINF> addresses) {
        this.addresses = addresses;
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
                ", address='" + this.addresses + '\'' +
                ", order='" + this.order + '\'' +
                '}';
    }
}
