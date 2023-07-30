package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App{

    public static AppiumDriver appiumDriver;
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
            cap.setCapability("noReset","true");

            appiumDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);

            // http://0.0.0.0:4723/wd/hub

            appiumDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
            appiumDriver.setSetting(Setting.WAIT_FOR_SELECTOR_TIMEOUT, 80);
            System.out.println("Starting the test....");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void atClose(Scenario scenario) {
        System.out.println("End of the test.");
        appiumDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        appiumDriver.setSetting(Setting.WAIT_FOR_SELECTOR_TIMEOUT, 80);
        appiumDriver.closeApp();

        // validate if scenario has failed
        if (scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) appiumDriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotBytes, "image/png", scenario.getName());
        }
    }


}
