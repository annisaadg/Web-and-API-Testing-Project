package com.tubes.websaucedemo.stepdefinition;

import com.tubes.websaucedemo.pages.CartPage;
import com.tubes.websaucedemo.pages.DashboardPage;
import com.tubes.websaucedemo.utils.DriverManager;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

public class EndToEndStepDefinitions {

    private WebDriver driver = null;
    private DashboardPage dashboard;
    private CartPage cart;

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        dashboard = new DashboardPage(driver);
        cart = new CartPage(driver);
    }


    @And ("I add an item to the cart")
    public void addItemToCart() {
        dashboard.addItemToCart();
    }

    @And ("I am on the cart page")
    public void verifyCartPage() {
        assertTrue(cart.isCartWithItemsDisplayed());
    }

    @And ("I click checkout")
    public void clickCheckoutButton() {
        cart.clickCheckout();
    }

    @After
    public void closeBrowser() {
        DriverManager.quitDriver();
    }

}