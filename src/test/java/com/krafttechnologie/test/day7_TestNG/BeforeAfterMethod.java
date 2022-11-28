package com.krafttechnologie.test.day7_TestNG;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setupClass(){
        System.out.println("-----------BeforeClass---------");
    }

    @Test
    public void test1(){
        System.out.println("First Test Case");
    }
    @Test @Ignore
    public void test2(){
        System.out.println("Second Test Case");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @AfterClass
    public void setupAfter(){
        System.out.println("--------AfterClass------");
    }


}
