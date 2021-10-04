package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.both.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ShippingPage extends BasePage
{
    public ShippingPage(WebDriver driver) throws IOException {
        super(driver);
    }
    public void continuetoPayment() throws Exception
    {
        message = "Pagina de envio, se continua aceptando los terminos y condiciones";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            scroll(browser,0,315);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.FOUR_STEP));
            click(browser, AutomationObjects.TERMSOFSERVICE);
            stepPass(browser, message + " - " + browser.getTitle());
            generateWord.sendText(message + " - " + browser.getTitle());
            generateWord.addImageToWord(browser);
            scroll(browser,0,700);
            click(this.browser, AutomationObjects.PROCEEDTOCHECKOUTSHIP);
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
