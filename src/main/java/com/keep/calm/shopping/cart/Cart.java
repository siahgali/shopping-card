package com.keep.calm.shopping.cart;

import com.keep.calm.shopping.customer.Customer;
import com.keep.calm.shopping.product.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private String cartId;
    private Customer customer;
    private List<CartItem> cartItemList;
    private double totalPrice;
    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    public void addProduct(Product product, Cart cart) {
        cartItemList = new ArrayList<>();
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setPrice(100);
        cartItem.setQuality(20);
        cartItemList.add(cartItem);
    }
}
