package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTests {
    public static void main(String[] args) throws Exception{
//
//
//        System.out.println("============================================");
//
//        BrowserFactory.getDriver("firefox");
//        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("http://google.com");
//        String fireTitle = firefoxDriver.getTitle();
//        System.out.println(fireTitle);
//        Thread.sleep(2000);
//        //firefoxDriver.quit();
//
//
//        firefoxDriver.get("https://etsy.com");
//        String fireTitle1 = firefoxDriver.getTitle();
//        System.out.println(fireTitle1);
//        Thread.sleep(2000);
//        firefoxDriver.navigate().back();
//        firefoxDriver.quit();
//
//        System.out.println("=============================");



        BrowserFactory.getDriver("Edge");
        EdgeDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://etsy.com");
        String edgeTitle = edgeDriver.getTitle();
        System.out.println(edgeTitle);
        Thread.sleep(2000);
       // edgeDriver.navigate().back();
      //  edgeDriver.quit();








    }

}
