package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;

public class BasePage extends BaseClass
{
    protected WebDriver browser;
    protected String message;

    public BasePage(WebDriver driver) {
        super(driver);
        this.browser = Hook.getDriver();
        message = "";
    }
    protected void hover(WebDriver driver, By locator) throws IOException
    {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(browser.findElement(locator)).build().perform();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }
    protected void clickOfList(WebDriver driver, By locator, int indexitem) throws IOException
    {
        try {
            driver.findElements(locator).get(indexitem).click();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }
    protected void hoverOfList(WebDriver driver, By locator, int indexitem) throws IOException
    {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(browser.findElements(locator).get(indexitem)).build().perform();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }
    @After
    public void tearDown()
    {
        this.browser.quit();
    }
}
