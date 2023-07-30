package com.appium.customer;

import java.util.Arrays;

public class CustomerList {

    String[] customerId = {"Store01", "Store02", "Store03", "Store04", "Store05"};
    public String setCustomerId() {
        String listId = Arrays.toString(customerId);

        return listId;
    }


}

