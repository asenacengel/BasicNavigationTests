package com.cbt.tests.TestNG;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class herokuappTestCases {

    private WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private Actions actions;

    @BeforeMethod
    public void setUp()throws Exception{
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        sleep(3);
        WebElement link =  driver.findElement(By.linkText("Status Codes"));
        link.click();




    }
    @Test(description = "Status Codes",dataProvider = "testData")
    public void statusCodeTest(By links ,String message){
        driver.findElement(links).click();
        String actual = driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(actual.contains(message));



    }
    @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][]{{By.linkText("200"),"This page returned a 200 status code"},
                {By.linkText("301"),"This page returned a 301 status code"},
                {By.linkText("404"),"This page returned a 404 status code"},
                {By.linkText("500"),"This page returned a 500 status code"}};
    }

   @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
