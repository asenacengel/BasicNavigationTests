package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class assignment_2 {

    private String URL = "http://practice.cybertekschool.com/dropdown";
    private WebDriver driver;

    @DataProvider(name="dropDown")
    public Object[][] testData(){
        return new Object[][]{
                {"year"  ,    String.valueOf( LocalDate.now().getYear())},
                {"month" ,   String.valueOf(LocalDate.now().getMonth())},
                {"day"   ,     String.valueOf(LocalDate.now().getDayOfMonth())}
        };
    }

    @BeforeMethod
    public void setUp()throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test (dataProvider = "dropDown")
    public void dropDownTest(String dropName, String actualData){

        String SelectedData=new Select(driver.findElement(By.id(dropName))).getFirstSelectedOption().getText().toLowerCase();
        Assert.assertEquals(actualData.toLowerCase(),SelectedData);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

