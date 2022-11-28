package com.krafttechnologie.test.day2_WebDriver_Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver1 = new ChromeDriver(); //polly
        driver1.get("https://www.google.com");

        //wait 3 second here then move on
        Thread.sleep(3000);

        //navigate to diger bir selenium metodudur
        driver1.navigate().to("https://www.facebook.com");

        //goes back to previous page
        Thread.sleep(3000);
        driver1.navigate().back();

        //goes to back to back
        Thread.sleep(3000);
        driver1.navigate().forward();

        //refresh to webpage
        Thread.sleep(3000);
        driver1.navigate().refresh();




    }
}
