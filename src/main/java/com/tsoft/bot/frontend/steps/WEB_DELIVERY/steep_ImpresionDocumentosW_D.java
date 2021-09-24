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
import net.bytebuddy.asm.Advice;
import org.apache.velocity.runtime.directive.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.tsoft.bot.frontend.pageobject.WEB_DELIVERY.PageObject_ImpresionDocumentosW_D.*;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class steep_ImpresionDocumentosW_D {
    private static final String EXCEL_WEB = "excel/BuscarOrden_WEB_DELIVERY.xlsx";
    private static final String ORDEN = "Orden";
    private static final String NUM_ORDEN = "ORDEN";

    private static GenerateWord generateWord = new GenerateWord();
    private WebDriver driver;
    public steep_ImpresionDocumentosW_D() {
        this.driver = Hook.getDriver();
    }
    private List<HashMap<String, String>> getData() throws Throwable {
        return ExcelReader.data(EXCEL_WEB, ORDEN);
    }
    @When("^Seleccionar impresion de documentos en WEB DELIVERY$")
    public void seleccionarImpresionDeDocumentosEnWEBDELIVERY() throws Exception {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(driver.findElement(LNK_GESTION_PEDIDO)).build().perform();
            Actions act2 = new Actions(driver);
            act2.moveToElement(driver.findElement(LNK_PREPARACION_PEDIDO)).build().perform();
            driver.findElement(LNK_IMPRESION_DOCUMENTOS).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Impresión de pedidos");
            generateWord.sendText("Impresión de pedidos");
            generateWord.addImageToWord(driver);

        }catch (Exception e){
            //ExcelReader.writeCellValue(EXCEL_WEB, ORDEN, 1, 19, "FAIL");
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @When("^click en ejecutar informes$")
    public void clickEnEjecutarInformes() throws Exception {
        try {
            driver.findElement(LST_SELECCIONAR_ACCION).click();
            Thread.sleep(1000);
            driver.findElement(LNK_EJECUTAR_INFORMES).click();
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ejecutar informes");
            generateWord.sendText("Ejecutar informes");
            generateWord.addImageToWord(driver);
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Imprimir guia de remision$")
    public void imprimirGuiaDeRemision() throws Exception {
        try {
            driver.findElement(LNK_GUIA_REMISION).click();
            Thread.sleep(2000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Página de solicitud");
            generateWord.sendText("Página de solicitud");
            generateWord.addImageToWord(driver);
            driver.findElement(TXT_NUM_SERIE).sendKeys("12345");
            Thread.sleep(1000);
            driver.findElement(TXT_CORRELATIVO_GUIA).sendKeys("12345");
            Thread.sleep(1000);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Solicitud completa");
            generateWord.sendText("Solicitud completa");
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_ENVIAR).click();
            Thread.sleep(10000);
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    ExtentReportUtil.INSTANCE.stepPass(driver.switchTo().window(windowHandle), "Informe guia de remision");
                    generateWord.sendText("Informe guia de remision");
                    generateWord.addImageToWord(driver.switchTo().window(windowHandle));
                    driver.switchTo().window(windowHandle).close();
                    driver.switchTo().window(parentWindow);
                    break;
                }
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Descarga completa");
            generateWord.sendText("Descarga completa");
            generateWord.addImageToWord(driver);
            Thread.sleep(5000);


        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }


    @And("^ingresar y buscar el numero de orden\\. \"([^\"]*)\"$")
    public void ingresarYBuscarElNumeroDeOrden(String casoDePrueba) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        try {
            int orden = Integer.parseInt(casoDePrueba) - 1;
            driver.findElement(TXT_ORDEN).clear();
            String user = getData().get(orden).get(NUM_ORDEN);
            driver.findElement(TXT_ORDEN).sendKeys(user);
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos el ID de orden");
            generateWord.sendText("Ingresamos el ID de orden");
            generateWord.addImageToWord(driver);
            driver.findElement(TXT_ORDEN).sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            if (driver.findElement(TBC_ORDEN).isDisplayed()){
                ExtentReportUtil.INSTANCE.stepPass(driver, "ID de orden encontrada");
                generateWord.sendText("ID de orden encontrada");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "ID de orden no encontrada");
                generateWord.sendText("ID de orden encontrada");
                generateWord.addImageToWord(driver);
            }


        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Reporte de preparacion por almacen$")
    public void reporteDePreparacionPorAlmacen() throws Exception {
        try {
            Thread.sleep(2000);
            driver.findElement(LNK_REPORT_ALMACEN).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Página de solicitud");
            generateWord.sendText("Página de solicitud");
            generateWord.addImageToWord(driver);
            Thread.sleep(3000);
            driver.findElement(TXT_COD_ALMACEN).sendKeys("=PE10API7");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos código de almacen");
            generateWord.sendText("Ingresamos código de almacen");
            generateWord.addImageToWord(driver);
            Thread.sleep(1000);
            driver.findElement(TXT_FECHA_PREPARACION).sendKeys("18/03/2020");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos fecha de preparación");
            generateWord.sendText("Ingresamos fecha de preparación");
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_ENVIAR_PREALM).click();
            Thread.sleep(10000);
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    ExtentReportUtil.INSTANCE.stepPass(driver.switchTo().window(windowHandle), "Reporte de preparacion por almacen");
                    generateWord.sendText("IReporte de preparacion por almacen");
                    generateWord.addImageToWord(driver.switchTo().window(windowHandle));
                    driver.switchTo().window(windowHandle).close();
                    driver.switchTo().window(parentWindow);
                    break;
                }
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Descarga completa");
            generateWord.sendText("Descarga completa");
            generateWord.addImageToWord(driver);
            Thread.sleep(5000);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Reporte de preparacion por envio$")
    public void reporteDePreparacionPorEnvio() throws Exception {
        try {
            Thread.sleep(2000);
            driver.findElement(LNK_REPORT_ENVIO).click();
            Thread.sleep(1000);
            driver.findElement(TXT_ALMACEN).sendKeys("=PE10API7");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos código de almacen");
            generateWord.sendText("Ingresamos código de almacen");
            generateWord.addImageToWord(driver);
            driver.findElement(TXT_FECHA_PREP).sendKeys("18/03/2020");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos fecha de preparación");
            generateWord.sendText("Ingresamos fecha de preparación");
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_ENVIAR_REPENV).click();
            Thread.sleep(10000);
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    ExtentReportUtil.INSTANCE.stepPass(driver.switchTo().window(windowHandle), "Reporte de preparacion por envio");
                    generateWord.sendText("Reporte de preparacion por envio");
                    generateWord.addImageToWord(driver.switchTo().window(windowHandle));
                    driver.switchTo().window(windowHandle).close();
                    driver.switchTo().window(parentWindow);
                    break;
                }
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Descarga completa");
            generateWord.sendText("Descarga completa");
            generateWord.addImageToWord(driver);
            Thread.sleep(5000);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Reporte de preparacion por pedido$")
    public void reporteDePreparacionPorPedido() throws Exception {
        try {
            Thread.sleep(2000);
            driver.findElement(LNK_REPORT_PEDIDO).click();
            Thread.sleep(1000);
            driver.findElement(TXT_COD_ALMAC).sendKeys("=PE10API7");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos código de almacen");
            generateWord.sendText("Ingresamos código de almacen");
            generateWord.addImageToWord(driver);
            driver.findElement(TXT_FECHA_PREPA).sendKeys("18/03/2020");
            ExtentReportUtil.INSTANCE.stepPass(driver, "Ingresamos fecha de preparación");
            generateWord.sendText("Ingresamos fecha de preparación");
            driver.findElement(BTN_ENVIAR_REPORTPEDID).click();
            Thread.sleep(10000);
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    ExtentReportUtil.INSTANCE.stepPass(driver.switchTo().window(windowHandle), "Reporte de preparacion por pedido");
                    generateWord.sendText("Reporte de preparacion por pedido");
                    generateWord.addImageToWord(driver.switchTo().window(windowHandle));
                    driver.switchTo().window(windowHandle).close();
                    driver.switchTo().window(parentWindow);
                    break;
                }
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Descarga completa");
            generateWord.sendText("Descarga completa");
            generateWord.addImageToWord(driver);
            Thread.sleep(5000);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @And("^Imprimir etiqueta$")
    public void imprimirEtiqueta() throws Exception {
        try {
            Thread.sleep(2000);
            driver.findElement(LNK_ETIQUETA).click();
            ExtentReportUtil.INSTANCE.stepPass(driver, "Pagina de solicitud");
            generateWord.sendText("Pagina de solicitud");
            generateWord.addImageToWord(driver);
            driver.findElement(BTN_ENVIAR_ETI).click();
            Thread.sleep(10000);
            String parentWindow = driver.getWindowHandle();
            Set<String> handles = driver.getWindowHandles();
            for (String windowHandle : handles) {
                if (!windowHandle.equals(parentWindow)) {
                    ExtentReportUtil.INSTANCE.stepPass(driver.switchTo().window(windowHandle), "Imprimir etiqueta");
                    generateWord.sendText("Imprimir etiqueta");
                    generateWord.addImageToWord(driver.switchTo().window(windowHandle));
                    driver.switchTo().window(windowHandle).close();
                    driver.switchTo().window(parentWindow);
                    break;
                }
            }
            ExtentReportUtil.INSTANCE.stepPass(driver, "Descarga completa");
            generateWord.sendText("Descarga completa");
            generateWord.addImageToWord(driver);
            Thread.sleep(5000);

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Then("^cerramos la ejecucion de informes$")
    public void cerramosLaEjecucionDeInformes() throws Exception {
        try {
            Thread.sleep(2000);
            driver.findElement(BTN_CANCELAR).click();
        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }
    }

    @Then("^verificar estado de los informes REALIZADO$")
    public void verificarEstadoDeLosInformesREALIZADO() throws Exception {
        try {
            Thread.sleep(2000);
            String estado1 = driver.findElement(TBC_IMPRIMIR_FACT).getText();
            String estado2 = driver.findElement(TBC_IMPRIMIR_GUIA).getText();
            String estado3 = driver.findElement(TBC_IMPRIMIR_ETIQ).getText();
            if (estado1.equals("REALIZADO") || estado2.equals("REALIZADO") || estado3.equals("REALIZADO")){
                ExtentReportUtil.INSTANCE.stepPass(driver, "Estado Correcto");
                generateWord.sendText("Estado Correcto");
                generateWord.addImageToWord(driver);
            }else {
                ExtentReportUtil.INSTANCE.stepFail(driver, "Estado Incorrecto");
                generateWord.sendText("Estado Incorrecto");
                generateWord.addImageToWord(driver);
            }

        }catch (Exception e){
            ExtentReportUtil.INSTANCE.stepFail(driver, "Fallo el caso de prueba : " + e.getMessage());
            generateWord.sendText("Tiempo de espera ha excedido");
            generateWord.addImageToWord(driver);
        }

    }
}
