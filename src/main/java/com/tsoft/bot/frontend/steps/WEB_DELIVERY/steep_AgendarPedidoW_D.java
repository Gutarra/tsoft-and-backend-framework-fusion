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
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_AgendarPedidoW_D.*;
import java.util.HashMap;
import java.util.List;
public class steep_AgendarPedidoW_D {
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;
    public steep_AgendarPedidoW_D() {
        this.driver = Hook.getDriver();
    }

    @Given("^Se da click en el boton agendar pedido \"([^\"]*)\"$")
    public void seDaClickEnElBotonAgendarPedido(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            Thread.sleep(2000);
            driver.findElement(BTN_AGENDAR_PEDIDO).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Agendar Pedido");
            generateWord.sendText("Agendar Pedido");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^Seleccionar fecha del pedido \"([^\"]*)\"$")
    public void seleccionarFechaDelPedido(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            Thread.sleep(2000);
            driver.findElement(LNK_FECHA_PEDIDO).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Seleccionamos fecha de pedido");
            generateWord.sendText("Seleccionamos fecha de pedido");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @And("^se da click en el boton aceptar \"([^\"]*)\"$")
    public void seDaClickEnElBotonAceptar(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            driver.findElement(BTN_BUSCAR).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Aceptar fecha");
            generateWord.sendText("Aceptar fecha");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }


    @Then("^se verifica que el estado del pedido sea agendado \"([^\"]*)\"$")
    public void seVerificaQueElEstadoDelPedidoSeaAgendado(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            Thread.sleep(3000);
            String estado = driver.findElement(TXT_AGENDADO).getAttribute("value");
            if (estado.equals("AGENDADO")){
                ExtentReportUtil.INSTANCE.stepPass(driver, "Pedido agendado");
                generateWord.sendText("Pedido agendado");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "Pedido no agendado");
                generateWord.sendText("Pedido no agendado");
                generateWord.addImageToWord(driver);
            }

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }
}
