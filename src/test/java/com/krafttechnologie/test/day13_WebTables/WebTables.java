package com.krafttechnologie.test.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.quit();

    }

    @Test
    public void printTable(){

        WebElement table= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']"));

        System.out.println("table.getText() = " + table.getText());

    }

    @Test
    public void printAllHeaders(){

        WebElement headers= driver.findElement(By.xpath("//table[@class='table table-light traversal-table'] /thead"));
        System.out.println("headers.getText() = " + headers.getText());

    }

    @Test
    public void printTableSize(){
        //th tag deki elementlerin size ini almak

        List<WebElement> thSize=driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //th"));
        System.out.println("thSize.size() = " + thSize.size());

        //rows (satırların) size ini almak

        List<WebElement> rwSize=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tr"));
        System.out.println("rwSize.size() = " + rwSize.size());

        //Headers (başlıklar) hariç rows size ini almak

        List<WebElement> allRowsWithoutheader=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr"));
        System.out.println("allRowsWithoutheader.size() = " + allRowsWithoutheader.size());


    }

    @Test
    public void getRow(){

        WebElement row2= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]"));

        System.out.println("row2.getText() = " + row2.getText());

    }

    @Test
    public void getAllRows() throws InterruptedException {

    List<WebElement> allRows=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr"));
    Thread.sleep(2000);

    for (int i=1; i<=allRows.size();i++){

        WebElement row= driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr["+i+"]"));
        System.out.println("row.getText() = " + row.getText());
    }

    }

    @Test
    public void getAllCellsOneRow(){

        List<WebElement>allcells=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]/td"));

        for(WebElement element: allcells){
            System.out.println("element.getText() = " + element.getText());
        }

    }

}
