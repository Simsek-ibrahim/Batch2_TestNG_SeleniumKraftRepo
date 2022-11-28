package com.krafttechnologie.test.day17_POM3;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.pages.ProfilePages;
import com.krafttechnologie.test.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ProfileTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();
    ProfilePages profilePages=new ProfilePages();

    @Test
    public void editProfile(){

        loginPages.loginUser();
        dashboardPage.myProfile.click();
        profilePages.profileTabs("Edit Profile");

        profilePages.fullName.clear();
        profilePages.fullName.sendKeys("Rabinson");

        profilePages.about.clear();
        profilePages.about.sendKeys("Some words are here");

        profilePages.company.clear();
        profilePages.company.sendKeys("GHAN IT");

        BrowserUtils.waitForPresenceOfElement(By.cssSelector("#terms"),5);
        BrowserUtils.dragAndDropBy(profilePages.slider,-150,0);

        Select select = new Select(profilePages.job);
        select.selectByVisibleText("Developer");

        profilePages.website.clear();
        profilePages.website.sendKeys("https://Krafttechnologie.com");

        profilePages.location.clear();
        profilePages.location.sendKeys("Istanbul");

        profilePages.skills.clear();
        profilePages.skills.sendKeys("TestNG,Cucumber");

        //profilePages.save.click();
        BrowserUtils.clickWithJS(profilePages.save);

    }

    @Test
    public void addExperience(){

    loginPages.loginUser();
    dashboardPage.myProfile.click();

    profilePages.profileTabs("Add Experience");

    profilePages.jobTitle.clear();
    profilePages.jobTitle.sendKeys("QA");

    profilePages.companyexperience.clear();
    profilePages.companyexperience.sendKeys("GHAN IT");

    profilePages.locationExperience.clear();
    profilePages.locationExperience.sendKeys("ANKARA");

    profilePages.startYear.clear();
    profilePages.startYear.sendKeys("02/02/2020");

    profilePages.endYear.clear();
    profilePages.endYear.sendKeys("02/02/2022");

    profilePages.jobDescription.clear();
    profilePages.jobDescription.sendKeys("Cool Workplace");

   // profilePages.addExperienceBtn.click();
        BrowserUtils.clickWithJS(profilePages.addExperienceBtn);


    }

}
