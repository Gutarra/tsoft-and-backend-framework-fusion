package com.tsoft.bot.frontend.objects;

import org.openqa.selenium.By;

public class AutomationObjects {
    private AutomationObjects() {
    }

    //Sign in
    public static final By TXT_EMAIl = By.name("email");
    public static final By TXT_PSWRD = By.name("passwd");
    public static final By BTN_SIGNIN = By.id("SubmitLogin");

    //Home page
    public static final By LINK_SIGNIN = By.className("login");

    //Store
    public static final By MENUITEM_WOMEN = By.cssSelector("a[title='Women']");
    public static final By SMWOMEN_EVENING_DRESSES = By.cssSelector("a[title='Evening Dresses']");
    public static final By PRODUCTS = By.cssSelector("div.product-container");
    public static final By NAMEPRODUCTS = By.cssSelector("a.product-name");
    public static final By BTN_ADDCARTPRODUCTS = By.cssSelector("a[title=\"Add to cart\"] span");
    public static final By CONTINUESHOOPING = By.cssSelector("span.continue span");
    public static final By PROCESSCHECKOUT = By.cssSelector("a[title=\"Proceed to checkout\"] span");

    //Shopping cart
    public static final By PROCEEDTOCHECKOUT = By.cssSelector("p a[title=\"Proceed to checkout\"] span");
    public static final By FIRST_STEP = By.cssSelector("li[class=\"step_current  first\"]");

    //Address
    public static final By PROCEEDTOCHECKOUTADD = By.cssSelector("button[name=\"processAddress\"] span");
    public static final By THIRD_STEP = By.cssSelector("li[class=\"step_current third\"]");

    //Shipping
    public static final By PROCEEDTOCHECKOUTSHIP = By.cssSelector("button[name=\"processCarrier\"] span");
    public static final By TERMSOFSERVICE = By.id("cgv");
    public static final By FOUR_STEP = By.cssSelector("li[class=\"step_current four\"]");

    //Payment
    public static final By PAYMETHODS = By.cssSelector("p.payment_module a");
    public static final By CONFIRMORDER = By.cssSelector("button[class=\"button btn btn-default button-medium\"]");
    public static final By ORDERSUCCESS = By.cssSelector("p.cheque-indent strong");
    public static final By END_STEP = By.cssSelector("li[class=\"step_current last\"]");
}