package steps;

import com.tsoft.bot.frontend.helpers.Hook;
import com.tsoft.bot.frontend.pages.OpenCartPage;
import cucumber.api.java.es.Y;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BuyProductsSteps {

    private WebDriver browser = Hook.getDriver();
    private OpenCartPage thepage = new OpenCartPage(browser);

    public BuyProductsSteps() throws IOException {
    }

    @Given("^go to the website$")
    public void goToTheWebsite() {
        System.out.println("Welcome ...");
    }

    @When("^the user \"([^\"]*)\" sign in on page$")
    public void theUserSignInOnPage(Integer testCase) throws Throwable {
        thepage.toSignIn(testCase);
        thepage.signIn(testCase);
    }

    @And("^buying two laptops and a camera$")
    public void buyingTwoLaptopsAndACamera() throws Throwable {
        thepage.buyLaptops();
        thepage.buyCamera();
        thepage.toShoppingCart();
    }

    @And("^the user records more details \"([^\"]*)\"$")
    public void theUserRecordsMoreDetails(Integer testCase) throws Throwable {
        thepage.continueOnBilling(testCase);
        thepage.continueOnDelivery();
        thepage.continueOnDeliveryMethod();
        thepage.continueOnPaymentMethod();
        thepage.confirmOrder();
    }

    @Then("^the order is registered$")
    public void theOrderIsRegistered() throws Throwable {
        thepage.compareResult();
    }
}
