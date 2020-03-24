package com.cbt.tests.TestNG;

import com.cbt.utilities.BrowserFactory;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class fileUploads {

    WebDriver driver;
    private String URL = "https://practice-cybertekschool.herokuapp.com";
    private Actions actions;

    @BeforeMethod
    public void setUp() {
        BrowserFactory.getDriver("chrome");
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
    @Test
            public void fileUploading()throws Exception{
        driver.findElement(By.linkText("File Upload")).click();
        WebElement file =  driver.findElement(By.id("file-upload"));
        String filePath = System.getProperty("user.dir")+"/pom.xml";
        file.sendKeys(filePath);
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(5000);

        String actual = "File Uploaded!";
        String expected =  driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(actual, expected);
        System.out.println(expected);
        String actual2  = "pom.xml";
        String expected2 = driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(actual2, expected2);

       Thread.sleep(3000);
    }
        @Test
        public void autocompleteTest() throws InterruptedException {
        driver.get(URL);
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.cssSelector("input[id='myCountry']")).sendKeys("United States of America");
            Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/input")).click();
        String actual = "You selected: United States of America";
        String expected = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        Assert.assertEquals(actual, expected);

        }
     

    @AfterMethod
    public void tearDown(){
        driver.quit();

    }

}
