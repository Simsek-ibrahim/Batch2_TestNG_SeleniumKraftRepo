package com.krafttechnologie.test.day9_WebElement3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownPractice3 {

    /*
    1. go to http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html
    2. Radio Button  kutusundaki elementlerin sayisini bul ve tum elementleri yazdir
    3. Blue elementini sec

        */

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
    public void test(){
    driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");

    List<WebElement> radioButtons= driver.findElements(By.xpath("//form[@id='radio-buttons']"));
        System.out.println("radioButtons.size() = " + radioButtons.size());

        for (WebElement radio: radioButtons){
        System.out.println("radio.getText() = " + radio.getText());
    }
    WebElement blue= driver.findElement(By.xpath("//input[@value='blue']"));
        blue.click();
}



}
