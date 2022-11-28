package com.krafttechnologie.test.day6_WebElement;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatConfirmation {
    public static void main(String[] args) throws InterruptedException {
        /** Class TAsk 3
         * open chrome browser
         *          go to https://www.krafttechexlab.com/login
         *         enter email as mike@gmail.com
         *         enter password as 12345
         *         click login btn
         *         verify that home page is "Dashboard"
         */

        String email="mike@gmail.com";
        String password="12345";


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");



        Thread.sleep(1000);

        WebElement emailInput=driver.findElement(By.id("email"));
        emailInput.sendKeys(email);

        WebElement passwoerdInput= driver.findElement(By.name("password"));
        passwoerdInput.sendKeys(password);


        WebElement loginBtn=driver.findElement(By.xpath("//button[.='Login']"));
        loginBtn.click();

        String expectedHomePage="Dashboard";
        String actualHomePage=driver.findElement(By.tagName("h1")).getText();



        Thread.sleep(1000);

        if(expectedHomePage.equals(actualHomePage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAILED");
        }

        driver.close();

    }
}
