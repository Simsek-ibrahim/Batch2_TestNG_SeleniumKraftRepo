package com.krafttechnologie.test.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenBrowser {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

//        WebDriverManager.chromedriver().setup();
//
//        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");
        driver.manage().window().maximize();
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}
