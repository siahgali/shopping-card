package com.keep.calm.shopping.customer;

import com.keep.calm.shopping.address.Address;
import com.keep.calm.shopping.cart.Cart;
import com.keep.calm.shopping.helper.JsonFileName;
import com.keep.calm.shopping.helper.JsonHelper;
import com.keep.calm.shopping.user.User;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String customerPhone;
    private Address shippingAddress;
    private Address billingAddress;
    private User users;
    private Cart cart;

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String custmerId) {
        this.customerId = custmerId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }
    public void addCustomer() {
        JsonHelper.addObjectToJsonFile(JsonFileName.CUSTOMER, this);
    }
}
