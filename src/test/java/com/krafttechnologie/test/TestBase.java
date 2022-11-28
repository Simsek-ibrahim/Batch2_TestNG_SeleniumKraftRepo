package com.krafttechnologie.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected ExtentReports report;

   protected ExtentHtmlReporter htmlReporter;

    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){

        report = new ExtentReports();

        String projectPath= System.getProperty("user.dir");
        String reportPath= projectPath + "/test-output/report.html";

       // String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
       // String reportPath=projectPath + "/test-output/report"+date+".html";

        htmlReporter=new ExtentHtmlReporter(reportPath);

        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Kraft.techB2 Smoke Test");

        report.setSystemInfo("Environment","Production");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer","Ibrahim");

    }

    @AfterTest
    public void tearDownTest(){

        report.flush();

    }

    @BeforeMethod
    public void setUP() {

        driver = Driver.get();
        driver.get(ConfigurationReader.get("url"));
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait=new WebDriverWait(Driver.get(),15);
        driver.get(ConfigurationReader.get("url"));
        driver.manage().window().maximize();
        actions=new Actions(driver);

    }

    @AfterMethod
    public void tearDown(ITestResult result) throws InterruptedException, IOException, IOException {
        //If Test Fails
        if (result.getStatus()==ITestResult.FAILURE){

            //Record the name of failed test
            extentLogger.fail(result.getName());
            //Take the screenshot and return the location of screenshot
            String screenShotPath= BrowserUtils.getScreenshot(result.getName());
            //Add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //Capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
        //driver.close();
        Driver.closeDriver();

    }




}
