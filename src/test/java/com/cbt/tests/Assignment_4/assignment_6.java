package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class assignment_6 {
    private WebDriver driver;
    private String URL = "https://www.w3schools.com";

    @BeforeTest
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }
    @Test
    public void links(){
        List<WebElement> allA = driver.findElements(By.tagName("</a>"));
        for(WebElement links :allA){
            System.out.println(links.getText().trim());
            Assert.assertTrue(links.isDisplayed());
        }
    }

    @AfterMethod
    public void tearDown(){driver.close();}




}
