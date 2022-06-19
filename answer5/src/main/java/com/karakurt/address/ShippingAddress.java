package com.karakurt.address;

public class ShippingAddress implements AddressINF {
    private String address;
    private AddressType addressType;
    @Override
    public String getAddress(){
        return address;
    }
    @Override
    public void setAddress(String address){
        this.address = address;
    }
    @Override
    public AddressType getAddressType() {
        return addressType;
    }
    @Override
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
    @Override
    public String toString() {
        return "ShippingAddress{" +
                ", address='" + this.address + '\'' +
                ", addressType=" + this.addressType +
                '}';
    }
}
