package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.common_files.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ShoppingCartPage extends BasePage
{
    public ShoppingCartPage(WebDriver driver) throws IOException {
        super(driver);
    }
    public void continueToCheckOut() throws Exception {
        message = "Se muestra el resumen de la compra, procedemos a caja";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.FIRST_STEP));
            scroll(browser,0,315);
            stepPass(browser, message + " - " + browser.getTitle());
            generateWord.sendText(message + " - " + browser.getTitle());
            generateWord.addImageToWord(browser);
            scroll(browser,0,700);
            click(this.browser, AutomationObjects.PROCEEDTOCHECKOUT);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }
}
