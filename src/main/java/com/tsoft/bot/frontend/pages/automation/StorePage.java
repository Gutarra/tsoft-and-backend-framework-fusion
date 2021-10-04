package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.both.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class StorePage extends BasePage
{
    public StorePage(WebDriver driver) {
        super(driver);
    }
    public void toEveningDresses() throws Exception
    {
        message = "Seleccionamos la categoria de \"Evening Dresses\"";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.MENUITEM_WOMEN));
            hover(this.browser,AutomationObjects.MENUITEM_WOMEN);
            stepPass(browser, message + " - " + browser.getTitle());
            generateWord.sendText(message + " - " + browser.getTitle());
            generateWord.addImageToWord(browser);
            click(this.browser, AutomationObjects.SMWOMEN_EVENING_DRESSES);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }
    public void pickProducts(int quantity) throws Exception
    {
        generateWord.sendText(quantity == 1 ? "Seleccionando producto" : String.format("Seleccionando un total de %d productos",quantity));
        int count = 0, product, max,scroll;
        String nameproduct;
        Random random = new Random();
        max = browser.findElements(AutomationObjects.PRODUCTS).size();
        do
        {
            message = "Agregando al carrito ";
            try
            {
                product = random.nextInt(max);
                nameproduct = browser.findElements(AutomationObjects.NAMEPRODUCTS).get(product).getText();
                scroll = browser.findElements(AutomationObjects.PRODUCTS).get(product).getLocation().y + browser.findElements(AutomationObjects.PRODUCTS).get(product).getSize().height;
                scroll(browser,0,-1000);
                scroll(browser,0,scroll);
                hoverOfList(browser,AutomationObjects.PRODUCTS,product);
                clickOfList(browser,AutomationObjects.BTN_ADDCARTPRODUCTS,product);
                stepPass(browser,message + nameproduct);
                generateWord.sendText(message + nameproduct);
                generateWord.addImageToWord(browser);
                if (count++ < quantity)
                    click(browser,AutomationObjects.CONTINUESHOOPING);
                count ++;
            }
            catch  (Exception we)
            {
                ExcelReader.writeCellValue(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.PAGE_NAME, 1, 19, "FAIL");
                stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
                generateWord.sendText("Fallo en tiempo de respuesta");
                generateWord.addImageToWord(browser);
            }
        }while (count < quantity);
        generateWord.sendText("Continuando con la compra.");
        click(browser,AutomationObjects.PROCESSCHECKOUT);
    }
}
