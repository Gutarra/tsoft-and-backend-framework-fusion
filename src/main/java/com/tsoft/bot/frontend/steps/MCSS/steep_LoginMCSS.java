package com.tsoft.bot.frontend.steps.MCSS;

import java.util.concurrent.TimeUnit;
import com.tsoft.bot.frontend.BaseClass;
import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.utility.ExcelReader;
import com.tsoft.bot.frontend.utility.ExtentReportUtil;
import com.tsoft.bot.frontend.utility.GenerateWord;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.HashMap;
import java.util.List;
import static com.tsoft.bot.frontend.pageobject.LoginMCSS.PageObject_LoginMCSS.*;

public class steep_LoginMCSS extends BaseClass {

    private static final String EXCEL_WEB = "excel/LoginMCSS.xlsx";
    private static final String LOGIN_WEB = "Login";
    private static final String COLUMNA_URL = "URL";
    private static final String COLUMNA_USUARIO = "Usuario";
    private static final String COLUMNA_CONTRASENIA = "Contraseña";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public steep_LoginMCSS() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, LOGIN_WEB);
    }

    @Given("^Ingreso a la url de MCSS \"([^\"]*)\"$")
    public void ingresoALaUrlDeMCSS(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        try {
        int MCSS = Integer.parseInt(casoDePrueba) - 1;
        String url = getData().get(MCSS).get(COLUMNA_URL);
        driver.get(url);
        sleep(5500);

        /*if(driver.findElement(BTN_CONFIGAVANZADA).isDisplayed()) {
            driver.findElement(BTN_CONFIGAVANZADA).click();
            sleep(3500);
            driver.findElement(LNK_CONTINUAR).click();
        }else{
                System.out.println("no hizo los pasos de los botones");
        }*/
        if (driver.findElement(RBTN_DEALER_USER).isDisplayed()){
            driver.findElement(RBTN_DEALER_USER).click();
            generateWord.sendText("Seleccionamos User dealer");
            generateWord.addImageToWord(driver);
            driver.findElement(LNK_DEALER_LOGIN).click();
            sleep(6500);

        }
            stepPass(driver, "Se inició correctamente la página MCSS");
        }catch (Exception e) {
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Ingreso el usuario de MCSS\"([^\"]*)\"$")
    public void ingresoElUsuarioDeMCSS(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int usuario = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_USUARIO).clear();
            sleep(3500);
            generateWord.sendText("Login");
            generateWord.addImageToWord(driver);
            String user = getData().get(usuario).get(COLUMNA_USUARIO);
            driver.findElement(TXT_USUARIO).sendKeys(user);
            sleep(3500);
            generateWord.sendText("Ingresamos el usuario");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^La contraseña de MCSS\"([^\"]*)\"$")
    public void laContraseñaDeMCSS(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int usuario = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_PASSWORD).clear();
            sleep(1500);
            String contra = getData().get(usuario).get(COLUMNA_CONTRASENIA);
            driver.findElement(TXT_PASSWORD).sendKeys(contra);
            generateWord.sendText("Ingresamos contraseña");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Then("^se da clic en el boton login de MCSS ingresando correctamente$")
    public void seDaClicEnElBotonLoginDeMCSSIngresandoCorrectamente() {
        try {
            driver.findElement(BTN_INGRESAR).click();
            sleep(35000);
            generateWord.sendText("Ingresamos a MCSS");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }


    }
}
