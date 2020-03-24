package com.cbt.tests.TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.Arrays;

import static java.lang.Thread.sleep;

public class Registration_Form {

    private String URL ="https://practice-cybertekschool.herokuapp.com";
    WebDriver driver;
    private Actions actions;
    private By registrrationBy = By.linkText("Registration Form");
    private By nameBy = By.name("firstname");
    private By lastnameBy = By.name("lastname");
    private By usernameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneNumberBy = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By otherBy = By.cssSelector("input[value='other']");
    private By birhdayBy =By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy = By.name("job_title");
    private By cPlusBy = By.cssSelector("input[id=\"inlineCheckbox1\"");
    private By javaBy = By.cssSelector("input[id=\"inlineCheckbox2\"");
    private By javaScriptBy = By.cssSelector("input[id=\"inlineCheckbox3\"");
    private By signUpBy = By.id("wooden_spoon");
    private By messageBy = By.tagName("p");




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
//
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


}
@Test
public void alphabeticCharacter() throws Exception  {
    driver.get(URL);
    driver.findElement(By.linkText("Registration Form")).click();
    driver.findElement(By.name("firstname")).sendKeys("a");
    Thread.sleep(3000);
    String expected = "first name must be more than 2 and less than 64 characters long";
    WebElement actual = driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
    Assert.assertEquals(expected,actual.getText());

}
@Test

public void AlpbeticalCharactesWithLastName()throws Exception{
    driver.get(URL);
    driver.findElement(By.linkText("Registration Form")).click();
    driver.findElement(By.name("lastname")).sendKeys("b");
    SleepInSeconds(3);
    String expected = "The last name must be more than 2 and less than 64 characters long";
    WebElement actual = driver.findElement(By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']"));
    Assert.assertEquals(expected, actual.getText());

}

@Test
public void registrationFormFillUp(){
    driver.get(URL);
    driver.findElement(By.linkText("Registration Form")).click();
    driver.findElement(nameBy).sendKeys("Asena");
    driver.findElement(lastnameBy).sendKeys("Cengel");
    driver.findElement(usernameBy).sendKeys("noname");
    driver.findElement(emailBy).sendKeys("asenaasena@gmail.com");
    driver.findElement(passwordBy).sendKeys("123456789");
    driver.findElement(phoneNumberBy).sendKeys("334-987-0978");
    driver.findElement(femaleBy).click();
    driver.findElement(birhdayBy).sendKeys("06/09/1987");
    Select departmentSelect = new Select(driver.findElement(departmentBy));
    departmentSelect.selectByVisibleText("Department of Agriculture");

    Select jobTitles = new Select(driver.findElement(jobTitleBy));
    jobTitles.selectByVisibleText("SDET");

    driver.findElement(javaBy).click();
    driver.findElement(signUpBy).click();
    String expected = "You've successfully completed registration!";
    String actual = driver.findElement(By.tagName("p")).getText();
    Assert.assertEquals(expected, actual);


}

@AfterMethod
    public void tearDown(){
    driver.quit();


}

}
