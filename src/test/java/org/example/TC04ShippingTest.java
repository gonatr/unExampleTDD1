package org.example;

import com.appium.customer.CustomerList;
import com.appium.product.ProductList;
import com.appium.product.ProductPrice;
import com.appium.product.ShippingProduct;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TC04ShippingTest {

    @DisplayName("Admin warehouse verify the order from drivers a.")
    @Test
    public void testShipping() {
        //Given
        ShippingProduct ship = new ShippingProduct(new ArrayList<>());
        ProductList productList = new ProductList();
        CustomerList customerList = new CustomerList();

        String customerCode = "Store05";

        //Then
        int order = productList.setQuantity(3);
        if(order != 5 || order == 0){
            assertTrue(customerList.setCustomerId().contains(customerCode));
            assertEquals(0, ship.getTotal(),0);
            System.out.println("Documents yang dibatalkan oleh = " + customerCode);
        }
    }

    @DisplayName("Admin warehouse verify the order from drivers b.")
    @Test
    public void testShippingOrder() {
        //Given
        ShippingProduct ship = new ShippingProduct(Arrays.asList(new ProductPrice(100, 3)));
        ProductList productList = new ProductList();

        int order = productList.setQuantity(3);
        int productStock = productList.stockProductID(2);

        //Then
        if (productStock <= order){
            System.out.printf("Diterima sebagian toko, dengan nilai harga product " + ship.getTotal() + ". Admin akan input QTY kembali untuk tiap product.");
            assertEquals(300, ship.getTotal(),0);
        } else if (productStock >= order){
            System.out.printf("Diterima Toko secara full QTY dengan Total Faktur " + ship.getTotal());
            assertEquals(300, ship.getTotal(),0);
        }
    }

    @DisplayName("Admin warehouse success verify order to driver c.")
    @Test
    public void testShippingOrder2() {
        //Given
        ShippingProduct ship = new ShippingProduct(Arrays.asList(new ProductPrice(100,1), new ProductPrice(200,1)));

        //Then
        assertEquals(300, ship.getTotal(),0);
    }
}
