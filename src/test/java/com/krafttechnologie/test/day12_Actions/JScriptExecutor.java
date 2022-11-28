package com.krafttechnologie.test.day12_Actions;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class JScriptExecutor {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void clickWithJS() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/floating_menu");

                WebElement button= driver.findElement(By.linkText("Elemental Selenium"));


        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                +"arguments[0].click()",button);
        Thread.sleep(2000);

        System.out.println("Title :" + js.executeScript("return document.title;").toString());
        System.out.println("Url :" + js.executeScript("return document.URL;").toString());

        String CurrentWindowHandle= driver.getWindowHandle();
        Set<String> windowhandles=driver.getWindowHandles();

        for(String handle: windowhandles){

            if(!handle.equals(CurrentWindowHandle)){
                driver.switchTo().window(handle);


            }

        }
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String expectedUrl="http://elementalselenium.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);


    }

    @Test
    public void typeWithJS(){

        driver.get("https://selectorshub.com/xpath-practice-page/");

        WebElement firstname= driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
        WebElement lastname= driver.findElement(By.xpath("//input[@placeholder='Enter Last name']"));

        JavascriptExecutor js= (JavascriptExecutor) driver;

        String name="Ali";
        String surname="Veli";

        js.executeScript("arguments[0].setAttribute('value', '" + name + "')", firstname);
        js.executeScript("arguments[0].setAttribute('value', '" + surname + "')", lastname);

    }

    @Test
    public void scrollDownAndUp() throws InterruptedException {

        driver.get("https://www.krafttechnologie.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,3000)");
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,-3000)");
        Thread.sleep(2000);


    }

}


