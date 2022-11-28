package com.krafttechnologie.test.day6_WebElement;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        //two ways to get from web element
        //1. getText() --> it will work %99 work and it will return string
        //2. getAttribute("value")--> second way of getting text especially input box

        String email="mike@gmail.com";


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");



        Thread.sleep(1000);

        WebElement emailInput=driver.findElement(By.id("email"));
        //emailInput.sendKeys(email);

        Thread.sleep(2000);

        String value= emailInput.getAttribute("class");
        System.out.println("value = " + value);
        Thread.sleep(2000);

        driver.close();


    }
}
