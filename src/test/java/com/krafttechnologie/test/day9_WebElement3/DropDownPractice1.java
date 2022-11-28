package com.krafttechnologie.test.day9_WebElement3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownPractice1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {

        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
        WebElement dropDownMenu1= driver.findElement(By.cssSelector("#dropdowm-menu-1"));
        Select selectOptions= new Select(dropDownMenu1);
        selectOptions.selectByValue("sql");

        Thread.sleep(2000);
        WebElement dropDownMenu2=driver.findElement(By.cssSelector("#dropdowm-menu-2"));
        Select selectoptions2= new Select(dropDownMenu2);
        selectoptions2.selectByIndex(2);


        Thread.sleep(2000);
        WebElement dropDownMenu3=driver.findElement(By.cssSelector("#dropdowm-menu-3"));
        Select selectOptions3= new Select(dropDownMenu3);
        selectOptions3.selectByVisibleText("CSS");

    }

}
