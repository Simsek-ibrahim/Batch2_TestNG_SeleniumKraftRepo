package com.krafttechnologie.test.day14_Properties_Singleton;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.test.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();

    @Test
    public void openBrowserUsingConfigurationReader() {

        //WebDriver driver= WebDriverFactory.getDriver(ConfigurationReader.get("browser"));

        driver.get(ConfigurationReader.get("url"));

        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password") + Keys.ENTER);



    }

    @Test

    public void loginWithMethod(){

        loginPages.loginUser();

        String actualTitle= dashboardPage.DashboardPageTitle("Dashboard");

        String expectedTitle="Dashboard";

        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle);
    }



}
