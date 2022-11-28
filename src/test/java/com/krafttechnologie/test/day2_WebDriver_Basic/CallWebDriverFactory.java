package com.krafttechnologie.test.day2_WebDriver_Basic;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechnologie.com");

        Thread.sleep(3000);
        driver.close();

    }
}
