package com.krafttechnologie.test.day4_Xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathStartsWith {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement searchbox= driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]"));
         searchbox.sendKeys("Java");

         WebElement searchbtn= driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH' )]"));
         searchbtn.click();

    }
}
