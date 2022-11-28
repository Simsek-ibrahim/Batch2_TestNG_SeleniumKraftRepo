package com.krafttechnologie.test.day12_Actions;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {

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
    public void uploadFile(){

        driver.get("https://demoqa.com/upload-download");

        WebElement chooseFile= driver.findElement(By.id("uploadFile"));

        chooseFile.sendKeys("C:\\Users\\FMÇ\\Desktop\\BAS2022015847292.PDF");

        WebElement testmsj= driver.findElement(By.id("uploadedFilePath"));

        System.out.println("testmsj.getText() = " + testmsj.getText());

        String actual= testmsj.getText();
        String expected= "BAS2022015847292.PDF";

        Assert.assertTrue(actual.contains(expected));



           }
    @Test
    public void uploadFile2(){

        driver.get("https://demoqa.com/upload-download");

                WebElement chooseFile= driver.findElement(By.id("uploadFile"));

        String projectPath= System.getProperty("user.dir");
        String FilePath= "src/test/resources/Deneme.txt";

        String fullPath= projectPath+"/"+FilePath;

        chooseFile.sendKeys(fullPath);

        WebElement testmsj= driver.findElement(By.cssSelector("#uploadedFilePath"));

        System.out.println("testmsj = " + testmsj.getText());

        String actual= testmsj.getText();
        String expected="Deneme.txt";

        Assert.assertTrue(actual.contains(expected));

    }

}
