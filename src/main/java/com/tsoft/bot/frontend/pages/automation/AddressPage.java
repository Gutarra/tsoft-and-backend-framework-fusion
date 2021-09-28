package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.frontend.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AddressPage extends BasePage
{
    public AddressPage(WebDriver driver) throws IOException {
        super(driver);
    }
    public void continueToShipping() throws Exception {
        message = "Se muestra datos de la dirección y adicionales de la compra, continuaremos";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            scroll(browser,0,315);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.THIRD_STEP));
            stepPass(browser, message + " - " + browser.getTitle());
            generateWord.sendText(message + " - " + browser.getTitle());
            generateWord.addImageToWord(browser);
            scroll(browser,0,700);
            click(this.browser, AutomationObjects.PROCEEDTOCHECKOUTADD);
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
