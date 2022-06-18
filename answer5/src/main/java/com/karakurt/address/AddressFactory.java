package com.karakurt.address;

import java.util.HashSet;
import java.util.Set;

public class AddressFactory {
    public static Set<AddressINF> createAddress(String addr){
        Set<AddressINF> addresses = new HashSet<>();
        AddressINF address = new Address();
        address.setAddress(addr);
        address.setAddressType(AddressType.SHIPPING);
        addresses.add(address);
        address.setAddressType(AddressType.BILLING);
        addresses.add(address);
        return addresses;
    }
}
