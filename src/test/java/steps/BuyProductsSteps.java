package steps;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.OpenCartPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BuyProductsSteps {

    private WebDriver browser ;
    private OpenCartPage thepage = new OpenCartPage(browser);

    public BuyProductsSteps() throws IOException {
        this.browser = Hook.getDriver();
    }

    @Dado("que el usuario ingresa a la página")
    public void queElUsuarioIngresaALaPágina() {
        System.out.println("Welcome ...");
    }

    @Cuando("inicia sesion en la página según el {int}")
    public void iniciaSesionEnLaPáginaSegunEl(Integer testCase)throws Throwable {
        thepage.toSignIn(testCase);
        thepage.signIn(testCase);
    }

    @Y("ingresa al listado de productos")
    public void ingresaAlListadoDeProductos() throws Throwable {
        thepage.buyLaptops();
        thepage.buyCamera();
        thepage.toShoppingCart();
    }

    @Y("selecciona un producto")
    public void seleccionaUnProducto() throws Throwable {

        thepage.buyLaptops();
        thepage.buyCamera();
    }

    @Entonces("se agrega al carrito de compras")
    public void seAgregaAlCarritoDeCompras() throws Throwable {
        thepage.toShoppingCart();
    }

    @Y("registra los datos para el envio {int}")
    public void registraLosDatosParaElEnvio(Integer testCase) throws Throwable {
        thepage.continueOnBilling(testCase);
        thepage.continueOnDelivery();
        thepage.continueOnDeliveryMethod();
        thepage.continueOnPaymentMethod();
        thepage.confirmOrder();
    }

    @Entonces("se confirma la creacción de la orden")
    public void seConfirmaLaCreacciónDeLaOrden() throws Throwable{
        thepage.compareResult();
    }
}
