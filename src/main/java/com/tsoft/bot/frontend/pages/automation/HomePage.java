package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.both.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class HomePage extends BasePage
{

    public HomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.PAGE_NAME);
    }

    public void startPagetoSignin() throws Throwable
    {
        message = "Cargando la pagina de inicio";
        try {
            int countPage = 0;
            String url = getData().get(countPage).get(ExcelAutomationDataObjects.COLUMN_URL);
            browser.get(url);
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.LINK_SIGNIN));
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,AutomationObjects.LINK_SIGNIN);
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
