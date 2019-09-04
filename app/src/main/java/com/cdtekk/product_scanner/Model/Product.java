package com.cdtekk.product_scanner.Model;

public class Product {

    public static final int PRODUCT_LIST_TYPE = 1;
    public static final int CART_LIST_TYPE = 0;

    public int type;
    public float price;
    public String productName;
    public int quantity;

    public Product(int type, String productName, float price, int quantity){
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }
}
