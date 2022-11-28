package com.krafttechnologie.test.day14_Properties_Singleton;

import com.krafttechnologie.test.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {

    @Test
    public void test1(){

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email"))
                .sendKeys(ConfigurationReader.get("userEmail"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password") + Keys.ENTER);

    }


}
