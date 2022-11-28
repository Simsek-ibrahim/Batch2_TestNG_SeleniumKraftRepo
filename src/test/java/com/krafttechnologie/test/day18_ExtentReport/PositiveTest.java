package com.krafttechnologie.test.day18_ExtentReport;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.test.TestBase;
import org.testng.annotations.Test;

public class PositiveTest extends TestBase {

    @Test
    public void loginTest1() {
        LoginPages loginPages = new LoginPages();
        extentLogger = report.createTest("Test1");
        loginPages.loginUser();
        System.out.println("1");

    }

    @Test
    public void loginTest2() {
        LoginPages loginPages = new LoginPages();
        extentLogger = report.createTest("Test2");
        loginPages.loginUser();
        System.out.println("2");

    }
}
