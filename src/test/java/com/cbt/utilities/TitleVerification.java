package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) throws Exception {

        List<String> urls = new ArrayList<>(Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown", "http://practice.cybertekschool.com/login"));


        WebDriver driver=   BrowserFactory.getDriver("Chrome");

        urls.forEach(url-> {
            driver.get(url);
            String title1 = driver.getTitle();
            System.out.println(title1);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });



        driver.quit();


    }
}
