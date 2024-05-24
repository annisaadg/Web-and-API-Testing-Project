package com.tubes.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DashboardPage {

    private WebDriver driver;

    private By menuButton = By.id("react-burger-menu-btn");
    private By logoutButton = By.id("logout_sidebar_link");
    private By aboutMenu = By.id("about_sidebar_link");
    private By allItemsMenu = By.id("inventory_sidebar_link");
    private By resetAppStateMenu = By.id("reset_sidebar_link");

    private By itemList = By.className("inventory_item");
    private By itemName = By.className("inventory_item_name");
    private By itemDescription = By.className("inventory_item_desc");
    private By itemPrice = By.className("inventory_item_price");
    private By itemImage = By.className("inventory_item_img");
    private By itemButton = By.className("btn_inventory");
    private By cartIcon = By.id("shopping_cart_container");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public void clickAbout() {
        driver.findElement(aboutMenu).click();
    }

    public boolean isMenuItemDisplayed(String menuItem) {
        switch (menuItem) {
            case "All Items":
                return driver.findElement(allItemsMenu).isDisplayed();
            case "About":
                return driver.findElement(aboutMenu).isDisplayed();
            case "Logout":
                return driver.findElement(logoutButton).isDisplayed();
            case "Reset App State":
                return driver.findElement(resetAppStateMenu).isDisplayed();
            default:
                throw new IllegalArgumentException("Menu item " + menuItem + " is not supported");
        }
    }

    public boolean isItemListDisplayed(String buttonText) {
        List<WebElement> items = driver.findElements(itemList);
        for (WebElement item : items) {
            boolean isNameDisplayed = item.findElement(itemName).isDisplayed();
            boolean isDescriptionDisplayed = item.findElement(itemDescription).isDisplayed();
            boolean isPriceDisplayed = item.findElement(itemPrice).isDisplayed();
            boolean isImageDisplayed = item.findElement(itemImage).isDisplayed();
            boolean isButtonDisplayed = item.findElement(itemButton).getText().equals(buttonText);
            
            if (!(isNameDisplayed && isDescriptionDisplayed && isPriceDisplayed && isImageDisplayed && isButtonDisplayed)) {
                return false;
            }
        }
        return true;
    }

    public void addItemToCart() {
        List<WebElement> items = driver.findElements(itemList);
        items.get(0).findElement(itemButton).click(); // Assuming we add the first item to the cart
    }

    public boolean isButtonChanged(String expectedButtonText) {
        String actualButtonText = driver.findElement(itemButton).getText();
        return actualButtonText.equals(expectedButtonText);
    }

    public boolean isCartIconDisplayed() {
        return driver.findElement(cartIcon).isDisplayed();
    }
    
}