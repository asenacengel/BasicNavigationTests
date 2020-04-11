package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    public void randomResult(){
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("wooden spoon", Keys.ENTER);
        Random random = new Random();


    }

}
