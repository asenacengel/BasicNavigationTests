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

import java.util.ArrayList;
import java.util.List;

public class assignment_5 {
    private WebDriver driver;
    private String URL = "https://www.amazon.com/gp/site-directory";



   @BeforeTest
       public void setUp()throws Exception {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
           driver.get(URL);
           driver.manage().window().maximize();
           Thread.sleep(3000);
   }

   @Test
    public void mainDepartments(){
       List<WebElement> deparments=driver.findElements(By.className("fsdDeptTitle"));
       List<String> departmentName = new ArrayList<>();
       deparments.forEach(eachD ->departmentName.add(eachD.getText().trim()));

       Select select = new Select(driver.findElement(By.id("searchDropdownBox")));
       List<WebElement> drops = select.getOptions();
       List<String> dropNames = new ArrayList<>();
       drops.forEach(eachdepartment -> dropNames.add(eachdepartment.getText().trim()));

       for(String name :departmentName){
           Assert.assertTrue(dropNames.contains(name),"Expected : "+name+" doesn't appear in least");
       }


   }


    @AfterMethod
    public void tearDown(){
       driver.close();
   }

}
