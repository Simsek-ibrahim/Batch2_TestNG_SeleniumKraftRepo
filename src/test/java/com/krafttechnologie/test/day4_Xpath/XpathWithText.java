package com.krafttechnologie.test.day4_Xpath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathWithText {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.krafttechexlab.com/");

        //String text= driver.findElement(By.xpath("//li[text()='All Users Prıofile']")).getText();

        String text= driver.findElement(By.xpath("//li[.='All Users Prıofile']")).getText();
        System.out.println("text = " + text);


    }
}
