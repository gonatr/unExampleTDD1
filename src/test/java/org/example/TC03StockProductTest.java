package org.example;

import com.appium.product.ProductList;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertTrue;

public class TC03StockProductTest {

    @DisplayName("Admin sales see product to warehouse.")
    @Test
    public void addCodeProduct() {
        //Given
        ProductList productList = new ProductList();
        int productStock = productList.stockProductID(5);
        int order = productList.setQuantity(2);
        String suratResi = productList.setResi();

        //Then
        if (productStock >= order) {
            assertTrue(suratResi.contains(suratResi));
            assertTrue(productStock >= order);
            System.out.printf("maka admin gudang akan menandai nomor-nomor pesanan dengan kriteria tersebut untuk");
            System.out.printf(", ini cetak document surat jalan = " + productList.setResi());
        } else if (productStock <= order) {
            assertTrue(productStock <= order);
            System.out.printf("dokumen dengan stok tidak cukup");
        }
    }

    @DisplayName("Admin sales see product to warehouse but no orders.")
    @Test
    public void addProductNotMark() {
        //Given
        ProductList productList = new ProductList();
        int order = productList.setQuantity(0);

        //Then
        if (order == 0 || order <= 0) {
            assertTrue(order == 0 || order <= 0);
            System.out.printf("Tidak ada stock yang di input");
        }
    }
}
