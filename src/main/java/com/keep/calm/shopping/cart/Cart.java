package com.keep.calm.shopping.cart;

import com.keep.calm.shopping.customer.Customer;

import java.util.List;

public class Cart {

    private String cartId;
    private List<CartItem> cartItemList;
    private double totalPrice;
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public void setCartItemList(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
