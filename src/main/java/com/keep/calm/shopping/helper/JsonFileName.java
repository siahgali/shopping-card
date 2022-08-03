package com.keep.calm.shopping.helper;

public enum JsonFileName {
    ADDRESS("address.json"),
    CUSTOMER("customer.json"),
    PRODUCT("product.json"),
    USER("user.json");

    private final String value;

    JsonFileName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
