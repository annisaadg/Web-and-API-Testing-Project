package com.tubes.websaucedemo.stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.tubes.websaucedemo.pages.DashboardPage;
import com.tubes.websaucedemo.pages.LoginPage;
import com.tubes.websaucedemo.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class MenuStepDefinitions {
    
    private WebDriver driver = null;
    private LoginPage login;
    private DashboardPage dashboard;

    private String username = "standard_user";
    private String password = "secret_sauce";
    private String loginPage = "https://www.saucedemo.com/";
    private String dashboardPage = "https://www.saucedemo.com/inventory.html";
    private String aboutPage = "https://saucelabs.com/";

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        login = new LoginPage(driver);
        dashboard = new DashboardPage(driver);
    }

    @Given("I have successfully logged in")
    public void verifyLoggedInSuccessfully() {
        driver.get(loginPage);
        login.enterUsername(username);
        login.enterPassword(password);
        login.clickLogin();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(dashboardPage));
    }

    @And("I have clicked the menu button")
    @When("I click the menu button")
    public void clickMenuButton() {
        dashboard.clickMenu();
    }

    @When("I click the {string} button")
    public void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "logout":
                dashboard.clickLogout();
                break;
            case "about":
                dashboard.clickAbout();
                break;
            default:
                throw new IllegalArgumentException("Button " + button + " is not supported");
        }
    }

    @Then("I have logged out successfully")
    public void verifyLoggedOutSuccessfully() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(loginPage));
    }

    @Then("I should be redirected to the Swag Labs website")
    public void verifyRedirectedToAboutPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(aboutPage));
    }

    @Then("I should see all menu items")
    public void verifyMenuItemsDisplayed() {
        assertTrue(dashboard.isMenuItemDisplayed("All Items"));
        assertTrue(dashboard.isMenuItemDisplayed("About"));
        assertTrue(dashboard.isMenuItemDisplayed("Logout"));
        assertTrue(dashboard.isMenuItemDisplayed("Reset App State"));
    }
    
    @After
    public void closeBrowser() {
        DriverManager.quitDriver();
    }

}