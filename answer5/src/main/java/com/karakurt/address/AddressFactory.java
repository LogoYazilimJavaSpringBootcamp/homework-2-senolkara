package com.karakurt.address;

public class AddressFactory {
    public static AddressINF createAddress(String addr, AddressType addressType){
        AddressINF address;
        switch (addressType){
            case BILLING -> {
                address = new BillingAddress();
            }
            case SHIPPING -> {
                address = new ShippingAddress();
            }
            default -> {
                throw new RuntimeException("AddressType not found");
            }
        }
        address.setAddress(addr);
        address.setAddressType(addressType);
        return address;
    }
}
