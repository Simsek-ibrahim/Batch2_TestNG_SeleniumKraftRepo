package com.krafttechnologie.test.day2_WebDriver_Basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        //Task open chrome and navigate to https://www.krafttechnologie.com
        //get page title

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.krafttechnologie.com");

        //getting title with selenium
        String title= driver.getTitle();

        System.out.println("title = " + title);

        //get to url from browser
        String currenturl= driver.getCurrentUrl();
        System.out.println("currenturl = " + currenturl);

        //get the source of page
        String pagesource=driver.getPageSource();
        System.out.println("pagesource = " + pagesource);

    }
}
