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
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_IngresoMaterialesW_D.*;
import java.util.HashMap;
import java.util.List;
public class steep_IngresoMaterialesW_D {
    private static final String EXCEL_WEB = "excel/BuscarOrden_WEB_DELIVERY.xlsx";
    private static final String ORDEN = "Orden";
    private static final String NUM_ORDEN = "ORDEN";
    private static final String NUM_IMEI = "NUM_IMEI";
    private static final String NUM_SIMCARD = "NUM_SIMCARD";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public steep_IngresoMaterialesW_D() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, ORDEN);
    }
    @Given("^Ingresar el numero de IMEI \"([^\"]*)\"$")
    public void ingresarElNumeroDeIMEI(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int user = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_IMEI).clear();
            String imei = getData().get(user).get(NUM_IMEI);
            driver.findElement(TXT_IMEI).sendKeys(imei);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el numero de IMEI");
            generateWord.sendText("Ingresamos el numero de IMEI");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }


    @When("^Ingresar el numero de SIMCARD \"([^\"]*)\"$")
    public void ingresarElNumeroDeSIMCARD(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int user = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_SIMCARD).clear();
            String simcard = getData().get(user).get(NUM_SIMCARD);
            driver.findElement(TXT_SIMCARD).sendKeys(simcard);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el numero de SIMCARD");
            generateWord.sendText("Ingresamos el numero de SIMCARD");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }

    @And("^click en el boton validar serie$")
    public void clickEnElBotonValidarSerie() throws Exception {
        try {
            driver.findElement(BTN_VALIDAR_SERIE).click();
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Validacion de series");
            generateWord.sendText("Validacion de series");
            generateWord.addImageToWord(driver);


        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Click en aceptar mensaje de validacion$")
    public void clickEnAceptarMensajeDeValidacion() throws Exception {
        try {
            Thread.sleep(3000);
            driver.findElement(BTN_ACEPTAR_VALIDAR_SERIE).click();
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Aceptamos el mensaje de validacion");
            generateWord.sendText("Aceptamos el mensaje de validacion");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Click en aceptar mensaje de refrescar sistema$")
    public void clickEnAceptarMensajeDeRefrescarSistema() throws Exception {
        try {
            Thread.sleep(2000);
            driver.findElement(BTN_ACEPTAR_REFRESCAR).click();
            Thread.sleep(5000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Aceptamos mensaje para refrescar la pagina");
            generateWord.sendText("Aceptamos mensaje para refrescar la pagina");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
    @And("^verificar que la orden quede en estado VALIDADO \"([^\"]*)\"$")
    public void verificarQueLaOrdenQuedeEnEstadoVALIDADO(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            Thread.sleep(4000);
            String IMEI = driver.findElement(TXT_AGENDADO_IMEI).getText();
            String SIMCARD = driver.findElement(TXT_AGENDADO_SIMCARD).getText();
            if (IMEI.equals("VALIDADO") && SIMCARD.equals("VALIDADO")){
                ExtentReportUtil.INSTANCE.stepPass(driver, "IMEI Y SIMCARD validados");
                generateWord.sendText("IMEI Y SIMCARD validados");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "IMEI Y SIMCARD no validados");
                generateWord.sendText("IMEI Y SIMCARD no validados");
                generateWord.addImageToWord(driver);
            }

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
        }


}
