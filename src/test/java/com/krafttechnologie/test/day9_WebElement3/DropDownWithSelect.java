package com.krafttechnologie.test.day9_WebElement3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        //1. dropdown diğer elementler gibi locate ediyoruz
        WebElement dropDownElement= driver.findElement(By.cssSelector("#oldSelectMenu"));

        //2. Elementi consructor gibi atayarak Selenium classindan bir object oluşturuyoruz

        Select selectMenu=new Select(dropDownElement);

        //Secilen ilk elemnti test edelim
        String expectedOption="Red";

        String actualOption= selectMenu.getFirstSelectedOption().getText();

        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");
//=========================================================================
        //DrpDown dan diğer optionları nasıl getiririz
        //1. Select visibleText kullanacağız

        Thread.sleep(2000);
        selectMenu.selectByVisibleText("Black");

        expectedOption="Black";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        //2. index kullanarak cagiriyoruz

        Thread.sleep(2000);
        selectMenu.selectByIndex(6);
        expectedOption="White";

        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");
 //=================================================================

        Thread.sleep(2000);
        selectMenu.selectByValue("3");
        expectedOption="Yellow";

        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");


    }

}
