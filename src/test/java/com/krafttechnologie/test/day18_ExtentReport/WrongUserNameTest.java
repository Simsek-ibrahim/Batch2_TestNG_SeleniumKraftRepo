package com.krafttechnologie.test.day18_ExtentReport;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.test.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUserNameTest extends TestBase {

    @Test
    public void wrongUsername(){

        LoginPages loginPages=new LoginPages();

        extentLogger=report.createTest("Wrong Username Test");

        extentLogger.info("Enter wrong username");

        loginPages.userEmailInput_loc.sendKeys("some username");

        extentLogger.info("Enter correct password");
        loginPages.passwordInput_loc.sendKeys("password");

        extentLogger.info("Click login button");
        loginPages.submitButton_loc.click();

        String actualMessage= loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Email address or password is incorrect. Please check");

        extentLogger.pass("PASSED");

    }

    @Test
    public void wrongPassword(){

        LoginPages loginPages=new LoginPages();

        extentLogger=report.createTest("Wrong password Test");

        BrowserUtils.waitFor(1);

        extentLogger.info("Enter correct username");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("Enter wrong password");
        loginPages.passwordInput_loc.sendKeys("some password");

        extentLogger.info("Click login button");
        loginPages.submitButton_loc.click();

        String actualMessage=loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT log in");
        Assert.assertEquals(actualMessage,"Email address or password is incorrect. Please check");
        //Assert.assertEquals(actualMessage,"AAAEmail address or password is incorrect. Please ");

        extentLogger.pass("PASSED");



    }


}
