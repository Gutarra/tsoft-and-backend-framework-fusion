package com.tsoft.bot.frontend.steps.buyproduct;

import com.tsoft.bot.frontend.pages.automation.front.BuyProductFront;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class BuyProductSteps
{
    private BuyProductFront webside;

    @Given("^go to the website automation$")
    public  void gotothewebsideAutomation() throws IOException {
        webside = new BuyProductFront();
    };

    @When("^the user sign in on page$")
    public void theUserSignInOnPage() throws Throwable
    {
        webside.goToSignIn();
        webside.signIn();
    }

    @And("^buying \"([^\"]*)\" product$")
    public void buyingProduct(Integer quantity) throws Exception
    {
        webside.toEveningDresses();
        webside.pickProduct(quantity);
        webside.continueToAddress();
        webside.continueToShipping();
        webside.continueToPayment();
        webside.selectPayMethod();
    }

    @Then("^order is registered$")
    public void orderIsRegistered() throws Exception
    {
        webside.confirmOrder();
        webside.checkResult();
    }
}
