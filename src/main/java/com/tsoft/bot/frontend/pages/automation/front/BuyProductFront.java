package com.tsoft.bot.frontend.pages.automation.front;

import com.tsoft.bot.frontend.pages.automation.BasePage;
import com.tsoft.bot.frontend.pages.automation.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BuyProductFront
{
    private BasePage page;
    private static WebDriver browser;
    public BuyProductFront() throws IOException {
        startUp();
    }

    protected void startUp() throws IOException {
        this.page = new BasePage(browser);
    }
    public void goToSignIn() throws Throwable
    {
        this.page = new HomePage(browser);
        ((HomePage) page).startPagetoSignin();
    }
    public void signIn() throws Throwable
    {
        this.page = new SigninPage(browser);
        ((SigninPage) page).singIn();
    }
    public void toEveningDresses() throws Exception
    {
        this.page = new StorePage(browser);
        ((StorePage) page).toEveningDresses();
    }
    public void pickProduct(int quantity) throws Exception
    {
        this.page = new StorePage(browser);
        ((StorePage) page).pickProducts(quantity);
    }
    public void continueToAddress() throws Exception
    {
        this.page = new ShoppingCartPage(browser);
        ((ShoppingCartPage) page).continueToCheckOut();
    }
    public void continueToShipping() throws Exception
    {
        this.page = new AddressPage(browser);
        ((AddressPage) page).continueToShipping();
    }
    public void continueToPayment() throws Exception
    {
        this.page = new ShippingPage(browser);
        ((ShippingPage) page).continuetoPayment();
    }
    public void selectPayMethod() throws Exception
    {
        this.page = new PaymentPage(browser);
        ((PaymentPage) page).selectMethod();
    }
    public void confirmOrder() throws Exception
    {
        this.page = new PaymentPage(browser);
        ((PaymentPage) page).confirmOrder();
    }
    public void checkResult() throws Exception
    {
        this.page = new PaymentPage(browser);
        ((PaymentPage) page).validateOrder();
    }
}
