package com.krafttechnologie.test.day8_WebElement_2;

import org.testng.Assert;
import org.testng.annotations.*;

public class SummaryOfTheLastLesson {

    @BeforeSuite
    public void beforesuit(){
        System.out.println("Before suit runs");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test runs");

    }
    @BeforeClass
    public void beforeClass(){

        System.out.println("Before Class runs");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method runs");
    }

    @Test
    public void test1(){
        Assert.assertTrue(4>2);
    }
    @Test
    public void test2(){
        Assert.assertFalse(1>2);
    }

    @Test
    public void test3(){
        Assert.assertEquals(1,1);
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method runs");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class runs");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test runs");
    }
    @AfterSuite
    public void afterSuit(){
        System.out.println("After Suit runs");
    }
}
