package com.appium.product;

public class ProductPrice {
    private  final double unitPrice;
    private final int quantity;
    public ProductPrice(double unitPrice, int quantity) {
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }
}
