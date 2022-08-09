package com.keep.calm.shopping.address;

import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;

import java.util.ArrayList;

public class Address {

    private String addressId;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String country;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void addAddress() {
        JsonHelper.addObjectToJsonFile(JsonFileName.ADDRESS, this);
    }

    // @Override
//    public boolean equals(Object obj) {
//        if (obj == this) {
//            return true;
//        }
//
//        if (!(obj instanceof Address)) {
//            return false;
//        }
//        Address that = (Address) obj;
//        return new EqualsBuilder()
//                .append(this.addressId, that.addressId)
//                .isEquals();
//    }


    public void updateAddress() {

        ArrayList<Address> objectList = JsonHelper.convertJsonFileToJavaObject(JsonFileName.ADDRESS);
        for (Address address:objectList){
            if(address.getAddressId().equals(this.getAddressId())){
                objectList.remove(address);
                objectList.add(this);
            }

        }





    }
    public void deleteAddress() { JsonHelper.deleteObjectToJsonFile(JsonFileName.ADDRESS, this);
    }


}

