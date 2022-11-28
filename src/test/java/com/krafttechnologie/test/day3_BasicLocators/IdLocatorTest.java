package com.krafttechnologie.test.day3_BasicLocators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        Faker faker=new Faker();

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");

        WebElement inputUserName= driver.findElement(By.id("userName"));
        inputUserName.sendKeys(faker.name().firstName());

        WebElement inputUserEmail= driver.findElement(By.id("userEmail"));
        inputUserEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(3000);




    }
}
