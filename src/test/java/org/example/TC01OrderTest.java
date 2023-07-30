package org.example;

import com.appium.customer.CustomerList;
import com.appium.product.ProductList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class TC01OrderTest {

    public static AppiumDriver appiumDriver;


    @Before
    public void setupDriver() {
        try {
            Properties properties = new Properties();
            FileInputStream propertiesFile = new FileInputStream("src/main/java/org/example/config/config.properties");
            properties.load(propertiesFile);

            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("deviceName", properties.getProperty("deviceName"));
            cap.setCapability("platformName", properties.getProperty("platformName"));
            cap.setCapability("platformVersion", properties.getProperty("platformVersion"));
            cap.setCapability("autoGrantPermissions", properties.getProperty("autoGrantPermissions"));
            cap.setCapability("appPackage", properties.getProperty("appPackage"));
            cap.setCapability("appActivity", properties.getProperty("appActivity"));
            cap.setCapability("noReset", "true");

            appiumDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

            appiumDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            appiumDriver.setSetting(Setting.WAIT_FOR_SELECTOR_TIMEOUT, 80);
            System.out.println("Starting the test....");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("User select a store name from list")
    @Test
    public void selectStoreNameCode() {
        //Given
        CustomerList customerList = new CustomerList();
        String customerCode = "Store05";

        //Then
        System.out.println("Success select a store name from list");
        assertTrue(customerList.setCustomerId().contains(customerCode));
        appiumDriver.quit();
    }

    @DisplayName("User select a product name from list")
    @Test
    public void selectCodeProduct() {
       //Given
       ProductList productList = new ProductList();
       String productCode = "ProductId05";

       //Then
       assertTrue(productList.setProductId().contains(productCode));
        System.out.println("Success select a product name from the list");
       appiumDriver.quit();
    }

    @DisplayName("User select a quantity products")
    @Test
    public void testUserSelectQuantity(){
        //Given
        ProductList productList = new ProductList();
        int productId = 2;
        int productQTY = productList.setQuantity(2);

        //Then
        assertTrue(productId == productQTY);
        appiumDriver.quit();
    }

    @DisplayName("User adds notes to product order")
    @Test
    public void addNotes(){
        //Given
        ProductList productList = new ProductList();
        String str = "Ini Catatan";

        //Then
        assertTrue(productList.remark("Ini Catatan").contains(str));
        appiumDriver.quit();
    }


    @DisplayName("User not select a store name from list")
    @Test
    public void notSelectProductID() {
        //Given
        ProductList productList = new ProductList();
        String customerCode = "Store06";

        //Then
        if (productList.setProductId().contains(customerCode)) {
            System.out.printf("Success selected Store ID");
        } else {
            System.out.printf("Please select store code ID");
        }
        appiumDriver.quit();
    }

    @DisplayName("User does not select a product from the list")
    @Test
    public void notSelectStoreCode() {
        //Given
        ProductList productList = new ProductList();
        String customerCode = "productId011";

        //Then
        if (productList.setProductId().contains(customerCode)) {
            System.out.printf("Success selected Product ID");
        } else {
            System.out.printf("Please select Product code ID");
        }
        appiumDriver.quit();
    }

    @DisplayName("User not input quantity from the list product")
    @Test
    public void notInputQTY() {
        //Given
        ProductList productList = new ProductList();
        int order = productList.setQuantity(-1);

        //Then
        if (order == 0 || order <= 0) {
            System.out.printf("Please input Quantity product code ID");
        } else {
            System.out.printf("Success selected Product ID");
        }
        appiumDriver.quit();
    }


}
