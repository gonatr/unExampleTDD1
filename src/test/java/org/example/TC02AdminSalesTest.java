package org.example;

import com.appium.product.ProductList;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class TC02AdminSalesTest {

    @DisplayName("Admin sales can see list orders input from salesman")
    @Test
    public void testAdminSales() {
        //Given
        ProductList productList = new ProductList();
        int productQTY = productList.setQuantity(2);
        int productStock = productList.stockProductID(5);
        int productGudang = productStock - productQTY;
        String productCode = "ProductId05";

        //Then
        System.out.printf("ini hasil = "+productGudang);

        if (productStock >= productQTY){
            assertTrue(productList.setProductId().contains(productCode));
            assertTrue(productStock >= productQTY);
            System.out.printf(", maka dia akan menandai nomor-nomor pesanan tsb untuk disiapkan oleh admin gudang.");
        } else if (productStock <= productQTY){
            assertTrue(productList.setProductId().contains(productCode));
            assertTrue(productStock <= productQTY);
            System.out.printf(", selisih qtynya dibuatkan menjadi dokumen pesanan baru.");
        }
    }

    @DisplayName("Admin sales see list orders not input from salesman")
    @Test
    public void stockProductMax() {
        //Given
        ProductList productList = new ProductList();
        int productQTY = productList.setQuantity(0);
        int productStock = productList.stockProductID(0);

        //Then
        if (productQTY == productStock) {
            assertTrue(productQTY == productStock);
            System.out.printf("Sales is a not inputted");
        }

    }
}
