package com.cbt.tests.vehiclePageTests;


import com.cbt.utilities.Driver;
import com.cbt.utilities.ScreenShot;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

public class vehicleDriverCostPage {

    private String URL ="https://qa1.vytrack.com";
    private WebDriver driver;

    private By usernameBy = By.id("prependedInput");
    private By passwordby = By.id("prependedInput2");
    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By costBy = By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[5]/a/span");
    private By createVehicleCost = By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div/div/div[2]/a");
    private By submitButton = By.className("btn btn-success action-button");
    private By cancelButton = By.className("btn back icons-holder-text ");


    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test(description = "Verify that truck driver should be able to see all cars' cost informations on the Vehicle Costs \n" +
            "page. ")
    public void vehicleCost() throws InterruptedException {
        driver.findElement(usernameBy).sendKeys("user19");
        driver.findElement(passwordby).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(fleetBy).click();
        driver.findElement(costBy).click();
        ScreenShot.getScreenShot("costPage");



    }

    @Test(description = "Verify that truck driver should be able to create Vehicle cost and cancel it. ")
    public void costAndCancel() throws InterruptedException {
        driver.findElement(usernameBy).sendKeys("user19");
        driver.findElement(passwordby).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(fleetBy).click();
        Thread.sleep(3000);
        driver.findElement(costBy).click();
        Thread.sleep(3000);
        driver.findElement(createVehicleCost).click();
        Thread.sleep(3000);
      driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div/div[1]/div[2]/div")).click();
       List<WebElement> chooseValue = driver.findElements(By.className("select2-result-label"));
        Actions actions = new Actions(driver);
        actions.moveToElement(chooseValue.get(2)).click().moveToElement(driver.findElement(By.className("select2-search-choice-close"))).click().perform();

        Driver.waitForPageToLoad(3);
        ScreenShot.getScreenShot("costPage");

    }

    @Test(description = "Verify that truck driver should be able to create Vehicle cost and cancel it. ")
    public void cancelVehicleCost() throws InterruptedException {
        driver.findElement(usernameBy).sendKeys("user19");
        driver.findElement(passwordby).sendKeys("UserUser123", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(fleetBy).click();
        Thread.sleep(3000);
        driver.findElement(costBy).click();
        Thread.sleep(3000);
        driver.findElement(createVehicleCost).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/form/div[2]/div[2]/div/div[1]/div[2]/div/fieldset/div/div[1]/div[2]/div")).click();
        List<WebElement> chooseValue = driver.findElements(By.className("select2-result-label"));
        Actions actions = new Actions(driver);
        chooseValue.get(2).click();
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.cssSelector("a[data-action='cancel"))).click().perform();
        Driver.waitForPageToLoad(3);
        ScreenShot.getScreenShot("cancelPage");


    }


    @AfterTest
    public void tearDown(){driver.close();}
}