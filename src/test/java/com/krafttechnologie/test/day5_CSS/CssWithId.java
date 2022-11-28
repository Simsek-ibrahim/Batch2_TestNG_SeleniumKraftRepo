package com.krafttechnologie.test.day5_CSS;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssWithId {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://wwwamazon.com");

        //WebElement inputSearchbox= driver.findElement(By.id("#twotabsearchtextbox"));

        WebElement SearchBox= driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        SearchBox.sendKeys("CSS");

        WebElement searchButton=driver.findElement(By.cssSelector("#nav-search-submit-button"));
        searchButton.click();

        Thread.sleep(3000);

        driver.close();

    }
}
