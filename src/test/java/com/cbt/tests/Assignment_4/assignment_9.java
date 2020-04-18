package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class assignment_9 {

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
    public void randomResult() throws InterruptedException {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);;
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"p_85/2470955011\"]/span/a/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("deliveryRefinements")).click();
        WebElement prices = driver.findElement(By.className("a-offscreen"));
        if(prices.equals("25")){
            System.out.println(false);
        } else {
            System.out.println(true);
        }





    }

}
