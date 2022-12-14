package com.krafttechnologie.test.day18_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports report;

    ExtentHtmlReporter htmlReporter;

    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){

        report = new ExtentReports();

        String projectPath= System.getProperty("user.dir");
        String reportPath= projectPath + "/test-output/report.html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Kraft.techB2 Smoke Test");

        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Ibrahim");
    }

    @Test

    public void test1() {

        //give a name to the current test
        extentLogger=report.createTest("TC001 Login Test");

        //Test steps
        extentLogger.info("Open the Browser");
        extentLogger.info("Go to url https://www.krafttechexlab.com/login");
        extentLogger.info("Enter username");
        extentLogger.info("Enter password");
        extentLogger.info("Click Login Button");
        extentLogger.info("Verify Logged in");
        extentLogger.info("TC001 Login Test is Passed");

    }

    @AfterMethod
    public void tearDown() {
        //this is when the report is actually created
        report.flush();
    }



    }

