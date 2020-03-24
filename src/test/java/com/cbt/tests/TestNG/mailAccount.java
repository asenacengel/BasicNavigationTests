package com.cbt.tests.TestNG;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class mailAccount {
    WebDriver driver;
    private String URL = "https://www.fakemail.net";
    private String URL2 = "https://practice-cybertekschool.herokuapp.com";
    private String URL3 = "https://www.fakemail.net";
    private Actions actions;

    @BeforeMethod
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        Thread.sleep(3000);
        actions = new Actions(driver);
    }
    @Test
    public void emailSignUp() throws InterruptedException {
        WebElement copyButton = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[3]/a[5]"));
        WebElement emailCopy = driver.findElement(By.className("animace"));
        actions.moveToElement(copyButton).click();
        String email = emailCopy.getText();
        System.out.println(email);
        Thread.sleep(3000);
        driver.navigate().to(URL2);
         driver.findElement(By.linkText("Sign Up For Mailing List")).click();
      driver.findElement(By.name("full_name")).sendKeys("asena");
      driver.findElement(By.name("email")).sendKeys(email);
      driver.findElement(By.name("wooden_spoon")).click();
      String expected = "Thank you for signing up. Click the button below to return to the home page.";
      String actual = driver.findElement(By.name("signup_message")).getText();
      Assert.assertEquals(expected, actual);
      Thread.sleep(2000);
      driver.navigate().to(URL3);
      WebElement emailComfirm =  driver.findElement(By.id("schranka"));
      List<WebElement> mailList = emailComfirm.findElements(By.tagName("tr"));
      mailList.get(0).click();
      String verify = driver.findElement(By.id("odesilatel")).getText();
      String expected2 = "Thanks for subscribing to practice.cybertekschool.com!";
      String actual2 = driver.findElement(By.id("predmet")).getText();
      Assert.assertEquals(expected2, actual2);







    }
    @AfterMethod
    public void tearDown(){
       // driver.quit();
    }


}
