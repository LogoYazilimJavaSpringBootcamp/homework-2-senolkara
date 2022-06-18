package com.karakurt.customer;

import com.karakurt.address.AddressINF;
import com.karakurt.address.AddressManager;
import com.karakurt.address.AddressType;
import com.karakurt.order.OrderINF;

import java.time.LocalDate;
import java.util.Set;

public class CustomerFactory {
    public static CustomerINF createCustomer(String username, String addr, OrderINF order, LocalDate createdDT){
        String firstName = splitUsername(username)[0];
        String lastName = splitUsername(username)[1];
        String email = createEmail(username);
        AddressManager addressManager = new AddressManager();
        Set<AddressINF> addresses = addressManager.createAddress(addr, AddressType.BILLING);
        CustomerINF customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);
        customer.setAddresses(addresses);
        customer.setOrder(order);
        customer.setCreatedDT(createdDT);
        return customer;
    }
    private static String createEmail(String username){
        String firstName = splitUsername(username)[0];
        String lastName = splitUsername(username)[1];
        return firstName.toLowerCase() + lastName.toLowerCase() + "@hotmail.com";
    }
    private static String[] splitUsername(String username){
        return username.split(" ");
    }
}
