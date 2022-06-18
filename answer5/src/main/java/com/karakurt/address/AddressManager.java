package com.karakurt.address;

import java.util.HashSet;
import java.util.Set;

public class AddressManager {
    public Set<AddressINF> createAddress(String addr, AddressType addressType){
        Set<AddressINF> addresses = new HashSet<>();
        Address address = new Address();
        address.setAddress(addr);
        address.setAddressType(addressType);
        addresses.add(address);
        return addresses;
    }
}
