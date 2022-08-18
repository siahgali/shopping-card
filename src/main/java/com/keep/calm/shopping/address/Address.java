package com.keep.calm.shopping.address;

import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    public void deleteAddress() {
        JsonHelper.deleteFromJsonFile(JsonFileName.ADDRESS, this);
    }

    public void updateAddress() {
        JsonHelper.updateJsonFile(JsonFileName.ADDRESS, this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Address)) {
            return false;
        }
        Address that = (Address) obj;
        return new EqualsBuilder()
                .append(this.addressId, that.addressId)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.addressId).toHashCode();
    }
}
