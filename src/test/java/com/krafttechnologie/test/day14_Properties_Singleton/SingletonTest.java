package com.krafttechnologie.test.day14_Properties_Singleton;

import org.testng.annotations.Test;

public class SingletonTest {

    @Test
    public void test1(){
        // Singleton singleton=new Singleton();

        String driver1=Singleton.getInstance();
        String driver2=Singleton.getInstance();

        System.out.println(driver1);
        System.out.println(driver2);

    }
}
