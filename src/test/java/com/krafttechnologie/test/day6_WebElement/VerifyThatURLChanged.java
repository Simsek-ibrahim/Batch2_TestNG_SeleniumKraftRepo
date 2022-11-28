package com.krafttechnologie.test.day6_WebElement;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatURLChanged {
    public static void main(String[] args) throws InterruptedException {

        /**
         *         open chrome browser
         *          go to https://www.krafttechexlab.com/login
         *         enter email as mike@gmail.com
         *         enter password as 12345
         *         click login btn
         *         verify that Url has changed
         */

        String email="mike@gmail.com";
        String password="12345";


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");


        String expectedURL=driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);
        Thread.sleep(1000);

        WebElement emailInput=driver.findElement(By.id("email"));
        emailInput.sendKeys(email);

        WebElement passwoerdInput= driver.findElement(By.name("password"));
        passwoerdInput.sendKeys(password);


        WebElement loginBtn=driver.findElement(By.xpath("//button[.='Login']"));
        loginBtn.click();

        String actualURL=driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);
        Thread.sleep(1000);

        if(expectedURL.equals(actualURL)){
            System.out.println("NOT CHANGED");
        }else{
            System.out.println("CHANGED");
        }

        driver.close();

    }
}
