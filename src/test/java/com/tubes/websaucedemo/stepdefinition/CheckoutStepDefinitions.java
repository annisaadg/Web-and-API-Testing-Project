package com.tubes.websaucedemo.stepdefinition;

import com.tubes.websaucedemo.pages.CartPage;
import com.tubes.websaucedemo.pages.CheckoutCompletePage;
import com.tubes.websaucedemo.pages.CheckoutPage;
import com.tubes.websaucedemo.pages.DashboardPage;
import com.tubes.websaucedemo.utils.DriverManager;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class CheckoutStepDefinitions {

    private WebDriver driver = null;
    private DashboardPage dashboard;
    private CartPage cart;
    private CheckoutPage checkout;
    private CheckoutCompletePage checkoutComplete;

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        dashboard = new DashboardPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        checkoutComplete = new CheckoutCompletePage(driver);
    }

    @And ("I have opened the cart page and clicked checkout")
    public void clickCartIcon() {
        dashboard.clickCart();
        cart.clickCheckout();
    }

    @And ("I fill the First Name with {string}")
    public void inputFirstName(String firstName) {
        checkout.enterFirstName(firstName);
    }

    @And ("I fill the Last Name with {string}")
    public void inputLasttName(String lastName) {
        checkout.enterLastName(lastName);
    }

    @And ("I fill the Postal Code with {string}")
    public void inputZipPostalCode(String postalCode) {
        checkout.enterPostalCode(postalCode);
    }

    @And ("I click the continue button")
    public void clickContinueButton() {
        checkout.clickContinue();
    }

    @Then ("I should see the page title {string}")
    public void verifyPageTitle(String pageTitle){
        assertTrue(checkout.isPageTitleCorrect(pageTitle));
    }

    @Then ("I should see list of items bought including the name, description, and price of the item")
    public void verifyListItemsBoughtDisplayed(){
        assertTrue(checkout.isItemBoughtDisplayed());
    }

    @Then ("I should see the payment information as {string}, shipping information as {string}, and Total Price information")
    public void verifyInformationDisplayed(String paymentInfo, String shippingInfo){
        assertTrue(checkout.isInformationDisplayed(paymentInfo, shippingInfo));
        assertTrue(checkout.isTotalPriceDisplayed());
    }

    @Then ("I should see Cancel Button and Continue Button")
    public void verifyCancelAndContinueButton() {
        assertTrue(checkout.isButtonDisplayed());
    }

    @And ("I have processed the checkout by filling the data with First Name {string}, Last Name {string}, and Postal Code {string}")
    public void processingCheckout(String firstName, String lastName, String postalCode) {
        clickCartIcon();
        inputFirstName(firstName);
        inputLasttName(lastName);
        inputZipPostalCode(postalCode);
        clickContinueButton();
    }

    @And ("I click the finish button")
    public void clickFinishButton() {
        checkout.clickFinish();
    }

    @Then("The checkout process is complete, showing Page Title {string}, Remark {string}, Description {string}, and a {string} button")
    public void verifyCheckoutComplete(String pageTitle, String remark, String description, String button) {
        assertTrue(checkoutComplete.isCheckoutCompletePageCorrect(pageTitle, remark, description, button));
    }

    @When ("I click the Back Home button")
    public void goBackToDashboard() {
        checkoutComplete.clickBackHomeButton();
    }

    @And ("I should see the dashboard page title {string}")
    public void verifyDashboardPageTitle(String pageTitle) {
        assertTrue(dashboard.isPageTitleCorrect(pageTitle));
    }

    @After
    public void closeBrowser() {
        DriverManager.quitDriver();
    }

}