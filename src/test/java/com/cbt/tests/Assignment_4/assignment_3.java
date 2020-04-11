package com.cbt.tests.Assignment_4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.YearMonth;

import java.util.List;
import java.util.Random;

public class assignment_3 {

    private String URL = "http://practice.cybertekschool.com/dropdown";
    private WebDriver driver;


    @BeforeMethod
    public void setUp()throws Exception{
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public void  SelectYourDateOfBirth() throws InterruptedException {
        Select years = new Select(driver.findElement(By.id("year")));
        List<WebElement> allYears = years.getOptions();

        Random random = new Random();
        int randomYear = random.nextInt(allYears.size());
        String selectedYear = allYears.get(randomYear).getText();
        years.selectByVisibleText(selectedYear);

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByIndex(0);


        YearMonth yearMonthObject = YearMonth.of(randomYear, 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        Select day = new Select(driver.findElement(By.id("day")));
        List<WebElement> allDays = day.getOptions();
        Assert.assertEquals(allDays.size(), daysInMonth );


        List<WebElement> allMonths = month.getOptions();

        for (WebElement selectedMonth : allMonths) {
            selectedMonth.click();
        // month.selectByIndex();
            YearMonth  monthOfTheYear = YearMonth.of(randomYear, Integer.parseInt(selectedMonth.getAttribute("value"))+1 );
            daysInMonth = monthOfTheYear.lengthOfMonth();

             day = new Select(driver.findElement(By.id("day")));
            allDays = day.getOptions();
            Assert.assertEquals(allDays.size(), daysInMonth );
            System.out.println(allDays.size());
            System.out.println(daysInMonth);
        }
    }

        @AfterMethod
        public void tearDown () {
            driver.quit();
        }

    }
