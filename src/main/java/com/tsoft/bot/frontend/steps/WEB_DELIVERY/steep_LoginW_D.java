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
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_LoginW_D.*;
import java.util.HashMap;
import java.util.List;
public class steep_LoginW_D {
    private static final String EXCEL_WEB = "excel/Login_WEB_DELIVERY.xlsx";
    private static final String LOGIN_WEB = "Login";
    private static final String COLUMNA_URL = "URL";
    private static final String COLUMNA_USUARIO = "Usuario";
    private static final String COLUMNA_CONTRASENIA = "Contraseña";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;

    public steep_LoginW_D() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, LOGIN_WEB);
    }

    @Given("^Ingreso a la url de WEB DELIVERY \"([^\"]*)\"$")
    public void ingresoALaUrlDeWEBDELIVERY(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int LoginWD = Integer.parseInt(casoDePrueba) - 1;
            String url = getData().get(LoginWD).get(COLUMNA_URL);
            driver.get(url);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se cargó correctamente la página");
            generateWord.sendText("Se cargó correctamente la página");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Ingreso el usuario de WEB DELIVERY\"([^\"]*)\"$")
    public void ingresoElUsuarioDeWEBDELIVERY(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int user = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_USER).clear();
            String usuario = getData().get(user).get(COLUMNA_USUARIO);
            driver.findElement(TXT_USER).sendKeys(usuario);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el usuario");
            generateWord.sendText("Ingresamos el usuario");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);

        }
    }

    @And("^La contraseña de WEB DELIVERY\"([^\"]*)\"$")
    public void laContraseñaDeWEBDELIVERY(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int PASS = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_PASSWORD).clear();
            String contra = getData().get(PASS).get(COLUMNA_CONTRASENIA);
            driver.findElement(TXT_PASSWORD).sendKeys(contra);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos la contraseña");
            generateWord.sendText("Ingresamos la contraseña");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Then("^se da clic en el boton login de WEB DELIVERY ingresando correctamente$")
    public void seDaClicEnElBotonLoginDeWEBDELIVERYIngresandoCorrectamente() throws Exception {
        try {
            driver.findElement(BTN_LOGIN).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Se ingresa correctamente");
            generateWord.sendText("Se ingresa correctamente");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExcelReader.writeCellValue(EXCEL_WEB, LOGIN_WEB, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }


}
