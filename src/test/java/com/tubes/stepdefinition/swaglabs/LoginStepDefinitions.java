package com.tubes.stepdefinition.swaglabs;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.tubes.pages.LoginPage;
import com.tubes.utils.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class LoginStepDefinitions {

    private WebDriver driver = null;
    private LoginPage login;
    
    private String loginPage = "https://www.saucedemo.com/";
    private String dashboardPage = "https://www.saucedemo.com/inventory.html";

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        login = new LoginPage(driver);
    }

    @Given("I am on the login page")
    public void goToLoginPage() {
        driver.get(loginPage);
    }

    @When("I fill in the username {string}")
    public void enterUsername(String username) {
        login.enterUsername(username);
    }

    @And("I fill in the password {string}")
    public void enterPassword(String password){
        login.enterPassword(password);
    }

    @And("I click the login button")
    public void clickLoginButton() {
        login.clickLogin();
    }

    @Then("I have logged in successfully")
    public void verifyLoggedInSuccessfully() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(dashboardPage));
    }

    @Then("I should remain on the login page")
    public void verifyRemainOnLoginPage() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(loginPage));
    }

    @Then("I should see the error message {string}")
    public void verifyErrorMessage(String errorMessage) {
        String actualErrorMessage = login.getErrorMessage();
        System.out.println("Expected error message: " + errorMessage);
        System.out.println("Actual error message: " + actualErrorMessage);
        assertEquals(errorMessage, actualErrorMessage);
    }

    @After
    public void closeBrowser() {
        DriverManager.quitDriver();
    }
}
