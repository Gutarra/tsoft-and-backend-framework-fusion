package com.tsoft.bot.frontend.steps.WEB_DELIVERY;

import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import com.tsoft.bot.frontend.utility.Sleeper;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_BuscarOrdenW_D.*;
import java.util.HashMap;
import java.util.List;

public class steep_BuscarOrdenW_D {
    private static final String EXCEL_WEB = "excel/BuscarOrden_WEB_DELIVERY.xlsx";
    private static final String ORDEN = "Orden";
    private static final String NUM_ORDEN = "ORDEN";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public steep_BuscarOrdenW_D() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, ORDEN);
    }

    @Given("^Se da click en el boton IR A en WEB DELIVERY \"([^\"]*)\"$")
    public void seDaClickEnElBotonIRAEnWEBDELIVERY(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            driver.findElement(LST_IR_A).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "IR A lista de pedidos");
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }


    @When("^Seleccionar auditoria de pedidos en WEB DELIVERY \"([^\"]*)\"$")
    public void seleccionarAuditoriaDePedidosEnWEBDELIVERY(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(LST_GEST_PEDIDO)).build().perform();
            driver.findElement(LST_AUD_PEDIDO).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Lista de pedidos");


        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Ingresar y buscar el numero de orden en WEB DELIVERY \"([^\"]*)\"$")
    public void ingresarElNumeroDeOrdenEnWEBDELIVERY(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int orden = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_IDORDEN).clear();
            String user = getData().get(orden).get(NUM_ORDEN);
            driver.findElement(TXT_IDORDEN).sendKeys(user);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el ID de orden");
            generateWord.sendText("Ingresamos el ID de orden");
            generateWord.addImageToWord(driver);
            driver.findElement(TXT_IDORDEN).sendKeys(Keys.ENTER);

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @Then("^Se encontrara la orden \"([^\"]*)\"$")
    public void seEncontraraLaOrden(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {

        Thread.sleep(5000);
        driver.findElement(TXT_BTN_PEDIDO).click();
        Thread.sleep(3000);
        ExtentReportUtil.INSTANCE.stepPass(driver, "Información del pedido");
        generateWord.sendText("Información del pedido");
        generateWord.addImageToWord(driver);


        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }



}
