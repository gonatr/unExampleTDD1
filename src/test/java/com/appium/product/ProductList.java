package com.appium.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class ProductList {

    public static UUID id;


    public int stockProductID(int stockId) {
        int stock = stockId;
        return stock;
    }

    String[] productsCode = {"ProductId01", "ProductId02", "ProductId03", "ProductId04", "ProductId05"};
    public String setProductId() {
        String listId = Arrays.toString(productsCode);
        return listId;
    }

    public int setQuantity(int qty) {
        int productIdStr = qty;
        return productIdStr;
    }

    public String remark(String remarkId) {
        String note = remarkId;
        return note;
    }

    public String setResi(){
        UUID idResi = UUID.randomUUID();
        return idResi.toString();

    }



}
