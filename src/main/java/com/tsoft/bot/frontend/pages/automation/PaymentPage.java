package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.frontend.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class PaymentPage extends BasePage
{
    public PaymentPage(WebDriver driver) throws IOException {
        super(driver);
    }
    public void selectMethod() throws Exception
    {
        message = "Se muestra los metodos de pago y se seleciona uno para proceder";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.PAYMETHODS));
            scroll(browser,0,315);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(this.browser, AutomationObjects.PAYMETHODS);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }
    public void confirmOrder() throws Exception
    {
        message = "Se muestran los detalles finales de la orden y se confirma la orden";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.END_STEP));
            scroll(browser,0,450);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(this.browser, AutomationObjects.CONFIRMORDER);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.PAGE_NAME, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }
    public void validateOrder() throws Exception {
        message = "Se busca el resultado esperado.";
        try
        {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.ORDERSUCCESS));
            scroll(browser,0,315);
            if (browser.findElement(AutomationObjects.ORDERSUCCESS).isDisplayed())
            {
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
                this.tearDown();
            }
            else
            {
                stepFail(browser,"No se encontro el mensaje de confirmación de la orden");
                generateWord.sendText("No se encontro el mensaje de confirmación de la orden");
                generateWord.addImageToWord(browser);
                this.tearDown();
            }

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
