package com.cbt.tests.Assignment_4;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class assignment_1 {

    private WebDriver driver;
    private  String URL= "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox";
    private By daysBy=By.className("gwt-CheckBox");
    private Actions actions;


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();



    }

    @Test
    public void selectCheckBox()throws Exception{
        driver.get(URL);
        Thread.sleep(3000);
        List<WebElement> chcBox=driver.findElements(daysBy);
        int count=1;
        Random rnd= new Random();
        while(count<=3){
            int randomDay = rnd.nextInt(7);

            if(chcBox.get(randomDay).findElement(By.tagName("input")).isEnabled()){
                chcBox.get(randomDay).click();
                System.out.println(chcBox.get(randomDay).getText());
                chcBox.get(randomDay).click();
                if(chcBox.get(randomDay).getText().equalsIgnoreCase("friday")){
                    count++;
                }
            }
        }









        }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
