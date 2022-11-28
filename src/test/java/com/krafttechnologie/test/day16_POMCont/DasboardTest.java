package com.krafttechnologie.test.day16_POMCont;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.test.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DasboardTest extends TestBase {

    LoginPages loginPages=new LoginPages();

    DashboardPage dashboardPage=new DashboardPage();

    @Test

    public void navigateToTabAndModule() throws InterruptedException {

        loginPages.loginUser();
        dashboardPage.navigateToModule("Components","Charts");

        String actualsubTitle= dashboardPage.subTitle("Charts");

        Assert.assertEquals(actualsubTitle,"Charts");

        Thread.sleep(3000);


    }

    @Test

    public void getUser() throws InterruptedException {

        loginPages.loginUser();
        String actualUser= dashboardPage.userNames("Jhon Nash");

        String expectedUser="Jhon Nash";
        Assert.assertEquals(actualUser,expectedUser);

        Thread.sleep(2000);

    }


}
