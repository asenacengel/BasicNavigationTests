package com.cbt.tests.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Registration_Form {

    private String URL ="https://practice-cybertekschool.herokuapp.com";
    WebDriver driver;


@BeforeMethod
    public void setUp() throws InterruptedException {
    WebDriverManager.chromedriver().version("79").setup();
    driver = new ChromeDriver();
    driver.get(URL);
    driver.manage().window().maximize();
    sleep(3);

}

private void SleepInSeconds(long seconds) throws InterruptedException {


    Thread.sleep(seconds *  1000);
}
@Test
public void registrationDateOfBirth() throws InterruptedException {
    driver.findElement(By.linkText("Registration Form")).click();
    driver.findElement(By.name("birthday")).sendKeys("wrong_dob");

    SleepInSeconds(3);
    String expected = "The date of birth is not valid";
    SleepInSeconds(5);
    String actual = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();

    Assert.assertEquals(expected, actual);

}

@Test
public void programmingLanguages() throws InterruptedException {
    driver.get(URL);
    driver.findElement(By.linkText("Registration Form")).click();
    SleepInSeconds(5);



    String expected = "c++,java,javascript";

    Object[] elementValues =  driver.findElements(By.className("form-check-label")).stream().map(element-> element.getText().toLowerCase()).toArray();
  String elementValuesString =  String.join(",", Arrays.copyOf(elementValues, elementValues.length, String[].class));
    Assert.assertEquals(elementValuesString, expected);
   // System.out.println(actual);

}
@AfterMethod
    public void tearDown(){
    driver.quit();


}

}
