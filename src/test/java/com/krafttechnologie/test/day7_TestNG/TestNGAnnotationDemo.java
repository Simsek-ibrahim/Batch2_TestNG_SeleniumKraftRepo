package com.krafttechnologie.test.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title", "title");

        System.out.println("Second Assertion");
        Assert.assertEquals("url","url");
    }

    @Test
    public void test2(){
        String expectedTitle="Kraft";
        String actualTitle="Krafttech";
        Assert.assertTrue(actualTitle.contains(expectedTitle),"verify that title starting Kraft");
    }


    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browsewr");
    }

}
