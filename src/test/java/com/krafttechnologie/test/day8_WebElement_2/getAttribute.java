package com.krafttechnologie.test.day8_WebElement_2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class getAttribute {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();

    }
    @Test
    public void test() {
        driver.get("https://demoqa.com/radio-button");
        WebElement yesButton= driver.findElement(By.cssSelector("#yesRadio"));
        System.out.println("yesButton.getAttribute() = " + yesButton.getAttribute("type"));
        System.out.println("yesButton.getAttribute() = " + yesButton.getAttribute("name"));


    }
}
