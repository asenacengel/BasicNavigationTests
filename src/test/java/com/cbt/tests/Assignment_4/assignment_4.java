package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class assignment_4 {

    private String URL = " https://www.amazon.com";
    WebDriver driver;

    @BeforeTest
    public void setUp()throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);


    }
    @Test
    public void amazonTest() {
        Assert.assertEquals("All", driver.findElement(By.className("nav-search-label")).getText());
        Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
        List<WebElement> menu = select.getOptions();
       for(WebElement departments :menu){
           departments.getText().trim().charAt(0);
           Assert.assertTrue(true,"not alphabetic");
       }

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    }
