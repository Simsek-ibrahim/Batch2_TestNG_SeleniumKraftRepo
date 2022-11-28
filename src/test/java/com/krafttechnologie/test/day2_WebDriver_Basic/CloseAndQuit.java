package com.krafttechnologie.test.day2_WebDriver_Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.krafttechnologie.com");

        Thread.sleep(2000);

        driver.close(); //close current tab gecerli sekme kapatma

        //go to facebook web addresses

        driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        Thread.sleep(3000);

        driver.quit(); //close all tab

    }
}
