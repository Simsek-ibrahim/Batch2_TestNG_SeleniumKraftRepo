package com.krafttechnologie.test.day5_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithStartsWith {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

       // WebElement searchBox= driver.findElement(By.cssSelector("#twotabsearchtextbox"));

        WebElement searchBox= driver.findElement(By.cssSelector("input[id^='textbox']"));
        searchBox.sendKeys("Cucumber");

        WebElement searchBtn= driver.findElement(By.cssSelector("input[id^='nav-search-']"));

        searchBtn.click();
        Thread.sleep(3000);
        driver.close();

    }
}
