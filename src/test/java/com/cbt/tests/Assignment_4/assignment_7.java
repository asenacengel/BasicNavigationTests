package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

public class assignment_7 {
    private WebDriver driver;
    private String URL = "https://www.selenium.dev/documentation/en/";

    @BeforeTest
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void validLinks(){
     List<WebElement> allLinks = driver.findElements(By.tagName("</a>"));
     for(WebElement links : allLinks){
      Assert.assertTrue(links.isSelected());
     }



    }
@AfterTest
    public void tearDown(){driver.close();}



}
