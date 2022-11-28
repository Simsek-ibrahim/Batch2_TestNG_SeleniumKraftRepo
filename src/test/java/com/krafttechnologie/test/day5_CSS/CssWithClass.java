package com.krafttechnologie.test.day5_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithClass {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBox.sendKeys("TestNg");

        WebElement searchBtn= driver.findElement(By.cssSelector(".nav-search-submit-text.nav-sprite.nav-progressive-attribute"));

        searchBtn.click();
        Thread.sleep(3000);
        driver.close();

    }
}
