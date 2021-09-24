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
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_SeleccionarSerie.*;
import java.util.HashMap;
import java.util.List;

public class steep_AsignarSeriesW_D {
    private static final String EXCEL_WEB = "excel/BuscarOrden_WEB_DELIVERY.xlsx";
    private static final String ORDEN = "Orden";
    private static final String NUM_ORDEN = "ORDEN";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;
    public steep_AsignarSeriesW_D() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, ORDEN);
    }

    @When("^Seleccionar asignacion de series en WEB DELIVERY$")
    public void seleccionarAsignacionDeSeriesEnWEBDELIVERY() throws Exception {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(LNK_GESTION_PEDIDO)).build().perform();
            Actions act2 = new Actions(driver);
            act2.moveToElement(driver.findElement(LNK_PREPARACION_PEDIDO)).build().perform();
            driver.findElement(LNK_ASIGNACION_SERIE).click();
            Thread.sleep(3000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Asignacion de series");
            generateWord.sendText("Asignacion de series");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^ingresar y buscar el numero de orden \"([^\"]*)\"$")
    public void ingresarYBuscarElNumeroDeOrden(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int orden = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_NUMERO_ORDEN).clear();
            String user = getData().get(orden).get(NUM_ORDEN);
            driver.findElement(TXT_NUMERO_ORDEN).sendKeys(user);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el ID de orden");
            generateWord.sendText("Ingresamos el ID de orden");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
       
    }

    @Then("^Se encontrara con exito la orden$")
    public void seEncontraraConExitoLaOrden() throws Exception {
        try {
            driver.findElement(TXT_NUMERO_ORDEN).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Orden encontrada");
            generateWord.sendText("Orden encontrada");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }


    }
}
