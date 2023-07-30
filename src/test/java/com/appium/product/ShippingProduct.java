package com.appium.product;

import java.util.List;

public class ShippingProduct {
    private final List<ProductPrice> products;

    public ShippingProduct(List<ProductPrice> products){
        this.products = products;
    }

    public double getTotal() {
        return products.stream().mapToDouble(products -> products.getUnitPrice() * products.getQuantity()).sum();
    }
}
