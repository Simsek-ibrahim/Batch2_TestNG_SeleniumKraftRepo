package com.krafttechnologie.test.day12_Actions;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsExamp {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void ciftClick() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement ciftClick= driver.findElement(By.id("double-click"));

        Actions action= new Actions(driver);

        Thread.sleep(2000);

        action.doubleClick(ciftClick).perform();
        Thread.sleep(2000);

}
    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement draggable= driver.findElement(By.id("draggable"));

        WebElement droppable= driver.findElement(By.id("droppable"));

        Actions actions=new Actions(driver);

        Thread.sleep(2000);
        actions.dragAndDrop(draggable,droppable).perform();
        Thread.sleep(2000);

      //  actions.moveToElement(draggable).clickAndHold().moveToElement(droppable).release().perform(); //2.Yol
    }

    @Test
    public void dragAndDrop2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/droppable");

        WebElement draggable=driver.findElement(By.id("draggable")); //source

        WebElement droppable=driver.findElement(By.id("droppable")); //target

        Actions actions=new Actions(driver);
        Thread.sleep(3000);
        actions.dragAndDrop(draggable,droppable).perform();

        System.out.println("droppable.getText() = " + droppable.getText());
        String except="Dropped!";
        Assert.assertEquals(droppable.getText(),except);
    }

    @Test
    public void hover1() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement hoverMe= driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement link1= driver.findElement(By.xpath("(//a[.='Link 1'])[1]"));

        Thread.sleep(2000);
        Actions actions=new Actions(driver);
        actions.moveToElement(hoverMe).perform();
        Thread.sleep(2000);

        Assert.assertTrue(link1.isDisplayed());

        link1.click();

        Alert alert=driver.switchTo().alert();

        System.out.println("alert.getText() = " + alert.getText());

        String actualtext= alert.getText();
        String expectedtext= "Well done you clicked on the link!";

        Assert.assertEquals(actualtext,expectedtext);

        Thread.sleep(2000);
        alert.accept();
    }

    @Test
    public void hover2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/tooltips");

                WebElement hovertool= driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));

        WebElement ontop= driver.findElement(By.xpath("//button[@data-bs-placement='top']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(hovertool).perform();
        Thread.sleep(2000);

        String expected="top";

        String actual=ontop.getAttribute("data-bs-placement");

        Assert.assertEquals(actual,expected);

        List<WebElement> hovers= driver.findElements(By.xpath("//button[@class='btn btn-secondary']"));

        for(WebElement hover: hovers){
            actions.moveToElement(hover).pause(2000).perform();
        }
    }

    @Test
    public void rightClick() throws InterruptedException {
        driver.get("https://demoqa.com/buttons");
        WebElement right=driver.findElement(By.id("rightClickBtn"));

        Actions actions= new Actions(driver);

        actions.contextClick(right).perform();

        Thread.sleep(2000);

        WebElement msj= driver.findElement(By.id("rightClickMessage"));

        String expected= "You have done a right click";
        String actual= msj.getText();

        Assert.assertEquals(actual,expected,"FAIL");

    }


}
