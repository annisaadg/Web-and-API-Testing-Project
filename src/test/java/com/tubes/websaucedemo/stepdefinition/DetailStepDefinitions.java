package com.tubes.websaucedemo.stepdefinition;

import com.tubes.websaucedemo.pages.LoginPage;
import com.tubes.websaucedemo.pages.DashboardPage;
import com.tubes.websaucedemo.pages.DetailPage;
import com.tubes.websaucedemo.utils.DriverManager;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DetailStepDefinitions {

    private WebDriver driver = null;
    private DetailPage detail;
    private DashboardPage dashboard;
    private LoginPage login;
    

    private String detailPage = "https://www.saucedemo.com/inventory-item.html?id=4";

    @Before
    public void setup(){
        driver = DriverManager.getDriver();
        detail = new DetailPage(driver); 
    }

    @And("I click the product image")
    public void clickGambarProduk() {
        detail.clickGambar();
    }

    @Then("I have to move to the product details page which displays product data")
    public void productsDetail() {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(detailPage));
        assertTrue(detail.isDetailPageDisplayed());
    }

}
