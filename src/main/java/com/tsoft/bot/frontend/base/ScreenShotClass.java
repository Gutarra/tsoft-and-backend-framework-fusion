package com.tsoft.bot.frontend.base;

import gherkin.lexer.Pa;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenShotClass
{
    public static void capture(WebDriver webDriver, String namescreenshoot)
    {
        TakesScreenshot takesScreenshot =  (TakesScreenshot) webDriver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        System.out.println(screenshot.getAbsolutePath());
        try
        {
            FileUtils.copyFile(screenshot, new File("target/screenshots/"+namescreenshoot+".png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void capture(WebDriver webDriver) throws IOException {
        TakesScreenshot takesScreenshot =  (TakesScreenshot) webDriver;
        File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try
        {
            FileUtils.copyFile(screenshot, new File("target/screenshots/"+ screenshot.getName()));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static Path takeScreenShoot(WebDriver driver)
    {
        Path currentpath = null;
        TakesScreenshot takesScreenshot = null;
        File screenshot = null;
        try
        {
            takesScreenshot =  ((TakesScreenshot) driver);
            screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("target/screenshots/"+ screenshot.getName()));
            currentpath = Paths.get(screenshot.getAbsolutePath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            return currentpath;
        }
    }
}
