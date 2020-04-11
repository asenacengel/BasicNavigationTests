package com.cbt.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenShot {



    public static String  getScreenShot(String name){
        // adding date and time to screenshot
        name = LocalDateTime.now() + "_" + name;
        // Where we gonna store ss
        String path = System.getProperty("user.dir")+"/test-output/screenshot/"+name+".png";
        System.out.println("Screenshot is here: "+path);
        //Since our reference type is a Webdriver
        // we can not see methods from TakesScreenShot interface
        //that's why we do casting
        TakesScreenshot takeScreenShot = (TakesScreenshot)Driver.getDriver();
        // take screenshot of web browser , and save it as a file
        File source = takeScreenShot.getScreenshotAs(OutputType.FILE);
        // where screenshot will be saved
        File destination = new File(path);
        try {
            FileUtils.copyFile(source, destination);
        }catch (IOException e){
            e.printStackTrace();
        }
        return path;
    }
}
