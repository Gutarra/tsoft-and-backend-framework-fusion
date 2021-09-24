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
// import org.sikuli.script.Region;
import org.testng.Assert;
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_AjusteInventario.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.List;
// import org.sikuli.script.Screen;
public class steep_AjusteInventarioW_D {
    private static final String EXCEL_WEB = "excel/AjusteInventario_WEB_DELIVERY.xlsx";
    private static final String GESTION_PEDIDO = "GestionPedido";
    private static final String COMENTARIO = "COMENTARIO";
    private static final String GUIA_REMISION = "GUIA_REMISION";
    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;
    public steep_AjusteInventarioW_D() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, GESTION_PEDIDO);
    }

    @When("^seleccionar ajuste de inventario$")
    public void seleccionarAjusteDeInventario() throws Exception {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(LNK_GESTION_PEDIDOS)).build().perform();
            Actions act2 = new Actions(driver);
            act2.moveToElement(driver.findElement(LNK_GESTION_INVENTARIOS)).build().perform();
            driver.findElement(LNK_AJUSTE_INVENTARIO).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ajuste de inventarios");
            generateWord.sendText("Ajuste de inventarios");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @And("^click en el boton nuevo registro$")
    public void clickEnElBotonNuevoRegistro() throws Exception {
        try {
            driver.findElement(BTN_NUEVO_REGISTRO).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Nuevo registro");
            generateWord.sendText("Nuevo registro");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^seleccionamos el tipo ABASTECIMIENTO \"([^\"]*)\"$")
    public void seleccionamosElTipo(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            driver.findElement(BTN_TIPO).click();
            Thread.sleep(1000);
            generateWord.sendText("Click ABASTECIMIENTO");
            generateWord.addImageToWord(driver);
            driver.findElement(LNK_ABASTECIMIENTO).click();
            Thread.sleep(2000);
            String estado = driver.findElement(TXT_TIPO).getAttribute("value");
            if (estado.equals("ABASTECIMIENTO")){
                ExtentReportUtil.INSTANCE.stepPass(driver, "Tipo: ABASTECIMIENTO");
                generateWord.sendText("Tipo: ABASTECIMIENTO");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "No seleccionó ABASTECIMIENTO");
                generateWord.sendText("No seleccionó ABASTECIMIENTO");
                generateWord.addImageToWord(driver);
            }

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @And("^ingresamos un comentario \"([^\"]*)\"$")
    public void ingresamosUnComentario(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int coment = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_COMENTARIO).clear();
            String comentario = getData().get(coment).get(COMENTARIO);
            driver.findElement(TXT_COMENTARIO).sendKeys(comentario);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos comentario");
            generateWord.sendText("Ingresamos comentario");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }

    @And("^ingresamos guia de remision \"([^\"]*)\"$")
    public void ingresamosGuiaDeRemision(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int guiarem = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_GUIA_REMISION).clear();
            String GuiaRemi = getData().get(guiarem).get(GUIA_REMISION);
            driver.findElement(TXT_GUIA_REMISION).sendKeys(GuiaRemi);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos guia de remision");
            generateWord.sendText("Ingresamos guia de remision");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^ingresamos el archivo \"([^\"]*)\"$")
    public void ingresamosElArchivo(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        /*try {
            driver.findElement(BTN_ADJUNTAR_ARCHIVOS).click();
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(LNK_ADJUNTAR_NUEVO_ARCHIVO)).build().perform();
            driver.findElement(LNK_ARCHIVO_NUEVO).click();
            Thread.sleep(2000);
           /* while (driver.findElement(IMG_ERROR).isDisplayed() == true){
                driver.findElement(BTN_ERROR_ACEPTAR).click();
                Thread.sleep(2000);
                driver.findElement(TXT_GUIA_REMISION).clear();
                driver.findElement(TXT_GUIA_REMISION).sendKeys("9876-1243216");
                driver.findElement(BTN_ADJUNTAR_ARCHIVOS).click();
                Actions act3 = new Actions(driver);
                act3.moveToElement(driver.findElement(LNK_ADJUNTAR_NUEVO_ARCHIVO)).build().perform();
                driver.findElement(LNK_ARCHIVO_NUEVO).click();
                Thread.sleep(2000);
            }
            System.out.println("passs");
            Thread.sleep(2000);
            generateWord.sendText("Agregamos nuevo archivo");
            generateWord.addImageToWord(driver);
            driver.switchTo().frame(0);
            driver.findElement(BTN_SELECCIONAR_ARCHIVO).click();
            Thread.sleep(1000);
            Robot robot = new Robot();
            String ruta = "D:\\ASIGNACIONES\\AsignacionSeries_3.csv";
            String text = ruta;
           StringSelection stringSelection = new StringSelection(text);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            Screen screen = new Screen();
            screen.wait(BTN_ACEPTAR_ARCHIVO);
            Region valBtn = screen.find(BTN_ACEPTAR_ARCHIVO).highlight(1,"green");
            screen.click(BTN_ACEPTAR_ARCHIVO);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }*/
    }

    @And("^click en ejecutar ajuste y aceptar mensaje$")
    public void clickEnEjecutarAjusteYAceptarMensaje() throws Exception {
        try {
            Thread.sleep(1000);
            driver.findElement(BTN_EJECUTAR_AJUSTE).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ejecutar ajuste");
            generateWord.sendText("Ejecutar ajuste");
            generateWord.addImageToWord(driver);
            Thread.sleep(2000);
            driver.findElement(BTN_ACEPTAR_AJUSTE).click();
            Thread.sleep(7000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Mensaje del sistema");
            generateWord.sendText("Mensaje del sistema");
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_ACEPTAR_SISTEMA).click();
            Thread.sleep(4000);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^validar que los archivos hayan cargado$")
    public void validarQueLosArchivosHayanCargado() throws Exception {
        try {
            if ((driver.findElement(TXT_IMEI_EXIST).isDisplayed()) || (driver.findElement(TXT_SIMCARD_EXIST).isDisplayed())) {
                ExtentReportUtil.INSTANCE.stepPass(driver, "Materiales cargados");
                generateWord.sendText("Materiales cargados");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo en la carga de materiales ");
                generateWord.sendText("Fallo en la carga de materiales");
                generateWord.addImageToWord(driver);
            }
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }
}
