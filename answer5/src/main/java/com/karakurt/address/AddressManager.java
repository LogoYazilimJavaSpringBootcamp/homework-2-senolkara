package com.karakurt.address;

public class AddressManager {
    public AddressINF createAddress(String addr, AddressType addressType){
        return AddressFactory.createAddress(addr, addressType);
    }
}
