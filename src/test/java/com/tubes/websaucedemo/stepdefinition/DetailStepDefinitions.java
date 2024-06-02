package com.tubes.websaucedemo.stepdefinition;

import com.tubes.websaucedemo.pages.DetailPage;
import com.tubes.websaucedemo.utils.DriverManager;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DetailStepDefinitions {

    private WebDriver driver = null;
    private DetailPage detail;
  
    private String detailPage = "https://www.saucedemo.com/inventory-item.html?id=4";

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        detail = new DetailPage(driver); 
    }

    @When("I click the product image")
    public void clickGambarProduk() {
        detail.clickGambar();
    }

    @Then("I have to move to the product details page which displays product data")
    @And("I am on the detail page")
    public void productsDetail() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(detailPage));
        assertTrue(detail.isDetailPageDisplayed());
    }

    @When("I click the add to cart button")
    public void clickTambahProduk() {
        detail.clickAddToCart();
    }

    @Then("I saw the Add to Cart button changed to the Remove button and the notification of the number of items on the cart icon changed where the number of items increased")
    public void addItem() {
        assertTrue(detail.isDetailPageDisplayed2());
    }

    @When("I click the Back to Product button")
    public void clickBack() {
        detail.clickBackToProduk();
    }

}
