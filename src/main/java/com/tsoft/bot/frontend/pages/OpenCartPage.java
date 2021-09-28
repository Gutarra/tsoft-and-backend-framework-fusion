package com.tsoft.bot.frontend.pages;

import com.tsoft.bot.frontend.base.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.objects.OpenCartObjects;
import com.tsoft.bot.frontend.objects.ExcelDataObjects;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.GenerateWord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class OpenCartPage extends BaseClass
{
    /* my custom voids */
    protected void hover(WebDriver driver, By locator) throws IOException
    {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(locator)).build().perform();
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }
    protected void awaitFor(WebDriver driver, By locator) throws IOException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        }catch (RuntimeException we){
            errorNoElementFound(driver, locator);
            throw we;
        }
    }

    protected WebDriver browser;
    private static GenerateWord generateWord = new GenerateWord();
    private String message;
    public OpenCartPage(WebDriver driver) throws IOException {
        super(driver);
        browser = Hook.getDriver();
    }
    private List<HashMap<String, String>> getDataForSignIn() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE);
    }
    private List<HashMap<String, String>> getDataForDetails() throws Throwable {
        return ExcelReader.data(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.DETAILS_PAGE);
    }
    public void toSignIn(Integer ncase) throws Throwable {
        message = "Se ingresa a la página de inicio";
        try
        {
            String url = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_URL);
            this.browser.get(url);
            click(browser,OpenCartObjects.NAV_ACCOUNT);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser, OpenCartObjects.BTN_TOSIGNIN);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void signIn(Integer ncase) throws Throwable {
        message = "Se inicia sesión en la pagina " + this.browser.getTitle();
        try
        {
            String username = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_USER);
            String password = getDataForSignIn().get(ncase - 1).get(ExcelDataObjects.COLUMN_PASWWORD);
            awaitFor(browser,OpenCartObjects.INPUT_EMAIL);

            clear(browser,OpenCartObjects.INPUT_EMAIL);
            typeText(browser,OpenCartObjects.INPUT_EMAIL,username);
            clear(browser,OpenCartObjects.IMPUT_PSWRD);
            typeText(browser,OpenCartObjects.IMPUT_PSWRD,password);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser, OpenCartObjects.BTN_LOGIN);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void buyLaptops() throws Throwable {
        message = "Ingresando a ver todas las laptos";
        try
        {
            scroll(browser,0,50);
            hover(browser,OpenCartObjects.NVIT_LAPTOPS);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser, OpenCartObjects.SMIT_LAPTOPS_SHOWALL);

            awaitFor(browser,OpenCartObjects.LAPTOPS_AWAIT);
            scroll(browser,0 , -1000);
            scroll(browser,0,520);
            message = "seleccionando laptop HP";
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.LAPTOP_HP);

            message = "agregando laptop HP al carrito";
            click(browser,OpenCartObjects.BTN_ADDCART);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            browser.navigate().back();

            awaitFor(browser,OpenCartObjects.LAPTOPS_AWAIT);
            message = "seleccionando laptop MACK";
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.LAPTOP_MACK);

            message = "agregando laptop MACK al carrito";
            click(browser,OpenCartObjects.BTN_ADDCART);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void buyCamera() throws Throwable {
        message = "Ingresando a la pagina de las camaras";
        try
        {
            browser.navigate().back();
            scroll(browser,0 , -1000);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.NVIT_CAMERAS);

            awaitFor(browser,OpenCartObjects.CAMERAS_AWAIT);
            message = "Seleccionando la camara Nikon";
            scroll(browser,0,190);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.CAMERA_NIKON);

            awaitFor(browser,OpenCartObjects.BTN_ADDCART);
            message = "agregando la camara Nikon al carrito";
            click(browser,OpenCartObjects.BTN_ADDCART);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void toShoppingCart() throws Throwable {
        message = "Ingresando a la pagina del carrito de compras";
        try
        {
            scroll(browser,0 , -1000);
            click(browser,OpenCartObjects.NAV_SHOPPINGCART);
            awaitFor(browser,OpenCartObjects.SHPC_CONTINUE);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);

            message = "Comparando montos finales";
            generateWord.sendText(message);
            double total, subtotal;
            total = getTotalOfDetails(browser,OpenCartObjects.SHPC_TOTALITEMS);
            subtotal = getValue(browser,OpenCartObjects.SHPC_SUBTOTAL);
            if (total == subtotal)
            {
                message = "Cálculo de montos correcto";
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            else
            {
                message = "Error en el cálculo de montos";
                stepFail(browser,message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            scroll(browser,0,520);
            click(browser,OpenCartObjects.SHPC_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnBilling(Integer ncase) throws Throwable {
        message = "Ingresando a los detalles de facturación, se ingresa nueva dirección";
        try
        {
            awaitFor(browser,OpenCartObjects.BILLING_CONTINUE);
            click(browser,OpenCartObjects.BILLING_NEWADDRESS);
            scroll(browser,0,-1000);
            scroll(browser,0,416);

            String firstname,lastname,address,city,postcode;
            firstname = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_FIRSTNAME);
            lastname = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_LASTNAME);
            address = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_ADDRESS);
            city = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_CITY);
            postcode = getDataForDetails().get(ncase - 1).get(ExcelDataObjects.COLUMN_POSTCODE);

            clear(browser,OpenCartObjects.BILLING_FIRSTNAME);
            typeText(browser,OpenCartObjects.BILLING_FIRSTNAME,firstname);
            clear(browser,OpenCartObjects.BILLING_LASTNAME);
            typeText(browser,OpenCartObjects.BILLING_LASTNAME,lastname);
            clear(browser,OpenCartObjects.BILLING_ADDRESS);
            typeText(browser,OpenCartObjects.BILLING_ADDRESS,address);
            clear(browser,OpenCartObjects.BILLING_CITY);
            typeText(browser,OpenCartObjects.BILLING_CITY,city);
            clear(browser,OpenCartObjects.BILLING_POSTCODE);
            typeText(browser,OpenCartObjects.BILLING_POSTCODE,postcode);

            awaitFor(browser,OpenCartObjects.BILLING_COUNTRY_SELECT);
            click(browser,OpenCartObjects.BILLING_COUNTRY);
            click(browser,OpenCartObjects.BILLING_COUNTRY_SELECT);

            awaitFor(browser,OpenCartObjects.BILLING_ZONE_SELECT);
            click(browser,OpenCartObjects.BILLING_ZONE);
            click(browser,OpenCartObjects.BILLING_ZONE_SELECT);

            awaitFor(browser,OpenCartObjects.BILLING_CONTINUE);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.BILLING_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnDelivery() throws Throwable {
        message = "Ingresando a los detalles de envio";
        try
        {
            awaitFor(browser,OpenCartObjects.DELIVERY_DETAILS_CONTINUE);
            scroll(browser,0,-1000);
            scroll(browser,0,190);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.DELIVERY_DETAILS_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnDeliveryMethod() throws Throwable {
        message = "Ingresando a los metodos de envio";
        try
        {
            awaitFor(browser,OpenCartObjects.DELIVERY_METHOD_CONTINUE);
            scroll(browser,0,-1000);
            scroll(browser,0,190);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
            click(browser,OpenCartObjects.DELIVERY_METHOD_CONTINUE);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void continueOnPaymentMethod() throws Throwable {
        message = "Ingresando a los metodos de pago";
        try
        {
            awaitFor(browser,OpenCartObjects.PAYMENT_CONTINUE);
            click(browser,OpenCartObjects.PAYMENT_AGREE);
            scroll(browser,0,-1000);
            scroll(browser,0,190);
            click(browser,OpenCartObjects.PAYMENT_CONTINUE);
            stepPass(browser, message);
            generateWord.sendText(message);
            generateWord.addImageToWord(browser);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void confirmOrder() throws Throwable {
        message = "Confirmando orden...";
        try
        {
            awaitFor(browser,OpenCartObjects.CONFIRM_ORDER);
            scroll(browser,0 , -1000);
            scroll(browser,0 , 250);

            message = "Comparando montos finales";
            double total, subtotal, flatShipping;
            total = getValue(browser,OpenCartObjects.ORDER_TOTAL);System.out.println("step here passed 1");
            subtotal = getValue(browser,OpenCartObjects.ORDER_SUBTOTAL);System.out.println("step here passed 2");
            flatShipping = getValue(browser,OpenCartObjects.ORDER_SHIPPINGRATE);System.out.println("step here passed 3");

            if (total == ( subtotal + flatShipping))
            {
                message += "\nCálculo de montos correcto";
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            else
            {
                message += "\nError en el cálculo de montos";
                stepFail(browser,message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
            }
            click(browser,OpenCartObjects.CONFIRM_ORDER);
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    public void compareResult() throws Throwable {
        message = "Buscando mensaje";
        try
        {
            scroll(browser,0 , -1000);
            scroll(browser,0 , 250);
            if (isDisplayed(browser, OpenCartObjects.SUCCESS_STATE))
            {
                message += "\nSe encontro el mensaje esperado";
                stepPass(browser, message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
                click(browser,OpenCartObjects.CONTINUE_HOME);
                this.browser.quit();
            }
            else
            {
                message += "\nError no se encontro el mensaje esperado";
                stepFail(browser,message);
                generateWord.sendText(message);
                generateWord.addImageToWord(browser);
                this.browser.quit();
            }
        }
        catch (Exception we)
        {
            ExcelReader.writeCellValue(ExcelDataObjects.EXCEL_DOC, ExcelDataObjects.SIGNIN_PAGE, 1, 19, "FAIL");
            stepFail(browser,"Fallo en tiempo de respuesta : " + we.getMessage());
            generateWord.sendText("Fallo en tiempo de respuesta");
            generateWord.addImageToWord(browser);
        }
    }

    protected Double getTotalOfDetails(WebDriver driver, By selectors)
    {
        Double total = 0.0;
        int cnt = 0, max = driver.findElements(selectors).size();
        while (cnt < max)
        {
            String number =  driver.findElements(selectors).get(cnt).getText().substring(1);
            number = number.replace(",","");
            Double val = Double.parseDouble(number);
            total += val;
            cnt++;
        }
        return total;
    }
    protected Double getValue(WebDriver driver, By selector)
    {
        Double subtotal = 0.0;
        subtotal = Double.parseDouble(driver.findElement(selector).getText().substring(1));
        return subtotal;
    }
}
