package com.krafttechnologie.test.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultibleWindows {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
      //  driver.close();
        driver.quit();
    }
    @Test
    public void twoWindows() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick = driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);


        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        Thread.sleep(2000);

        //String titleAfterClick=driver.getTitle();
        //System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle(); // title The Internet and has ID --> CDwindow-86FF1E88C72D706A5C38610F849D5408
        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) { // go and check one by one

            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }

        System.out.println("driver.getTitle() = " + driver.getTitle());

    }

    @Test
    public void multipleWindows() {
        driver.get("https://the-internet.herokuapp.com/windows");

        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

        WebElement click_here = driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles();

        for (String tab : windowHandles) {
            driver.switchTo().window(tab);
            //if(driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/windows/new")){
            if (driver.getTitle().equals("New Window")) {
                //stop on this now
                break;
            }
        }
        System.out.println("after click = " + driver.getTitle());
    }


}
