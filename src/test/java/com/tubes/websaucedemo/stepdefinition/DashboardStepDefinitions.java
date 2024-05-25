package com.tubes.websaucedemo.stepdefinition;

import com.tubes.websaucedemo.pages.DashboardPage;
import com.tubes.websaucedemo.utils.DriverManager;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DashboardStepDefinitions {

    private WebDriver driver = null;
    private DashboardPage dashboard;
    private String dashboardPage = "https://www.saucedemo.com/inventory.html";

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        dashboard = new DashboardPage(driver);
    }

    @Given("I am on the dashboard page")
    public void goToDashboardPage() {
        driver.get(dashboardPage);
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(dashboardPage));
    }

    @Then("I should see a list of items with name, description, image, price, and an {string} button")
    public void verifyItemsDisplayed(String buttonText) {
        assertTrue(dashboard.isItemListDisplayed(buttonText));
    }

    @Given("I have added an item to the cart")
    public void addItemToCart() {
        dashboard.addItemToCart();
    }

    @Then("the button should change to {string}")
    public void verifyButtonChange(String buttonText) {
        assertTrue(dashboard.isButtonChanged(buttonText));
    }

    @Then("I should see the cart icon displayed")
    public void verifyCartIconDisplayed() {
        assertTrue(dashboard.isCartIconDisplayed());
    }

    @After
    public void closeBrowser() {
        DriverManager.quitDriver();
    }

}