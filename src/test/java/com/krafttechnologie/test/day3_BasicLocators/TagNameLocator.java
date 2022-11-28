package com.krafttechnologie.test.day3_BasicLocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(3000);

        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@gmail.com");

        WebElement passwoordInputBox=driver.findElement(By.name("password"));
        passwoordInputBox.sendKeys("12345");

        //2. Yol- LAZY WAY
        // driver.findElement(By.name("password")).sendKeys("12345");

        Thread.sleep(3000);

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();

        //verify that you are on the dashboard page

        System.out.println("driver.findElement(By.tagName(\"h1\"))" +
                " = " + driver.findElement(By.tagName("h1")));


    }
}
