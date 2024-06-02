package com.tubes.websaucedemo.stepdefinition;

import com.tubes.websaucedemo.pages.CartPage;
import com.tubes.websaucedemo.utils.DriverManager;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import static org.junit.Assert.assertTrue;


public class CartStepDefinitions {

    private WebDriver driver = null;
    private CartPage cart;
  
    private String cartPage = "https://www.saucedemo.com/cart.html";


    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        cart = new CartPage(driver); 
    }

    @And("I click the cart icon")
    public void i_click_the_cart_icon() {
        cart.clickCartIcon();
    }

    @Then("I see an empty cart page that contains Title page, Continue Shopping button, Checkout button")
    public void i_see_an_empty_cart_page() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(cartPage));        
        assertTrue(cart.isEmptyCartDisplayed());

    }

    @And("I click the add to cart in product Sauce Labs Backpack button")
    public void i_click_the_add_to_cart_button(){
        cart.clickAddToCartButton();
    }

    @Then("I see a cart page with items that contain Title page, List of items containing item name, item description, and price, Continue Shopping button, Checkout button")
    public void i_see_a_cart_page_with_items() {
        assertTrue(cart.isCartWithItemsDisplayed());

    }

    @When("I click the Continue Shopping button")
    public void i_click_the_continue_shopping_button() {
        cart.clickContinueShoppingButton();
    }
}
