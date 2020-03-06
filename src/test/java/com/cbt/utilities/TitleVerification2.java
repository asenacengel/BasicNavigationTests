package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification2 {
    public static void main(String[] args)throws Exception {

        List<String> urls = Arrays.asList("https://lulugandgeorgia.com", "https://wayfair.com/",

                "https://walmart.com, ","https://westelm.com");

        WebDriver driver = BrowserFactory.getDriver("chrome");

        urls.forEach(url->{
            driver.get(url);
            String title = driver.getTitle();

            System.out.println(title);

        });

        Thread.sleep(3000);
        driver.quit();





        }
    }

