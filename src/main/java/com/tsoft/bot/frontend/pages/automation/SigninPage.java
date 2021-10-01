package com.tsoft.bot.frontend.pages.automation;

import com.tsoft.bot.frontend.objects.AutomationObjects;
import com.tsoft.bot.frontend.objects.ExcelAutomationDataObjects;
import com.tsoft.bot.common_files.utility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SigninPage extends BasePage
{
    public SigninPage(WebDriver driver) throws IOException {
        super(driver);
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(ExcelAutomationDataObjects.EXCEL_DOC, ExcelAutomationDataObjects.AUTH_PAGE);
    }

    public void singIn() throws Throwable
    {
        message = "Se inicia sesión en el sistema";
        try {
            WebDriverWait wait = new WebDriverWait(browser, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(AutomationObjects.TXT_EMAIl));
            scroll(browser,0,315);
            Random random = new Random();
            Integer count = random.nextInt(8);
            String username = getData().get(count).get(ExcelAutomationDataObjects.COLUMN_USERNAME);
            String password = getData().get(count).get(ExcelAutomationDataObjects.COLUMN_PASWWORD);
            clear(browser,AutomationObjects.TXT_EMAIl);
            clear(browser, AutomationObjects.TXT_PSWRD);
            typeText(browser,AutomationObjects.TXT_EMAIl,username);
            typeText(browser,AutomationObjects.TXT_PSWRD,password);
            stepPass(browser, message + " - " + browser.getTitle());
            generateWord.sendText(message + " - " + browser.getTitle());
            generateWord.addImageToWord(browser);
            click(this.browser, AutomationObjects.BTN_SIGNIN);
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
