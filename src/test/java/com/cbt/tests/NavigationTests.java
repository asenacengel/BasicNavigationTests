package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTests {
    public static void main(String[] args) throws Exception{


        BrowserFactory.getDriver("chrome");
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        String title = driver.getTitle();
        System.out.println(title);
        Thread.sleep(2000);
        driver.quit();

        BrowserFactory.getDriver("chrome");
        ChromeDriver driver1 = new ChromeDriver();
        driver1.get(" https://etsy.com");
        String etsyTitle = driver1.getTitle();
        System.out.println(etsyTitle);
        driver1.navigate().back();

        if(etsyTitle.contains("etsy")){
            System.out.println("Title is true");
        }else {
            System.out.println("Title is false ");
        }
        driver1.navigate().forward();
        Thread.sleep(3000);
        driver1.getTitle();
        driver1.quit();


    }

}
