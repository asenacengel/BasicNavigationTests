package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

public class assignment_8 {
    private WebDriver driver;
    private String URL = "https://amazon.com";

    @BeforeTest
    public void setUp()throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        Thread.sleep(3000);
    }

    @Test
    public void cart() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);;

        Thread.sleep(3000);
       List<WebElement> allbrands = driver.findElements(By.id("brandsRefinements"));
       for (WebElement brand : allbrands){
           System.out.println(brand.getText());

        Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"p_85/2470955011\"]/span/a/i")).click();
        List<WebElement> primeAllBrands = driver.findElements(By.id("brandsRefinements"));
        for(WebElement primeBrands : primeAllBrands) {
            System.out.println(primeBrands.getText());

            Assert.assertEquals(allbrands.size(), primeAllBrands.size());
        }
        }


    }
    @AfterTest
    public void tearDown(){driver.close();}

}
