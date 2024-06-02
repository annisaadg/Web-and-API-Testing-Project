package com.tubes.websaucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutMenu;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsMenu;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetAppStateMenu;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> itemList;

    @FindBy(className = "inventory_item_name")
    private WebElement itemName;

    @FindBy(className = "inventory_item_desc")
    private WebElement itemDescription;

    @FindBy(className = "inventory_item_price")
    private WebElement itemPrice;

    @FindBy(className = "inventory_item_img")
    private WebElement itemImage;

    @FindBy(className = "btn_inventory")
    private WebElement itemButton;

    @FindBy(id = "shopping_cart_container")
    private WebElement cartIcon;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMenu() {
        menuButton.click();
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public void clickAbout() {
        aboutMenu.click();
    }

    public void clickCart() {
        cartIcon.click();
    }

    public boolean isMenuItemDisplayed(String menuItem) {
        switch (menuItem) {
            case "All Items":
                return allItemsMenu.isDisplayed();
            case "About":
                return aboutMenu.isDisplayed();
            case "Logout":
                return logoutButton.isDisplayed();
            case "Reset App State":
                return resetAppStateMenu.isDisplayed();
            default:
                throw new IllegalArgumentException("Menu item " + menuItem + " is not supported");
        }
    }

    public boolean isItemListDisplayed(String buttonText) {
        for (WebElement item : itemList) {
            boolean isNameDisplayed = item.findElement(By.className("inventory_item_name")).isDisplayed();
            boolean isDescriptionDisplayed = item.findElement(By.className("inventory_item_desc")).isDisplayed();
            boolean isPriceDisplayed = item.findElement(By.className("inventory_item_price")).isDisplayed();
            boolean isImageDisplayed = item.findElement(By.className("inventory_item_img")).isDisplayed();
            boolean isButtonDisplayed = item.findElement(By.className("btn_inventory")).getText().equals(buttonText);
            
            if (!(isNameDisplayed && isDescriptionDisplayed && isPriceDisplayed && isImageDisplayed && isButtonDisplayed)) {
                return false;
            }
        }
        return true;
    }

    public boolean isPageTitleCorrect(String expectedPageTitle) {
        String actualPageTitle = pageTitle.getText();
        return actualPageTitle.equals(expectedPageTitle);
    }


    public void addItemToCart() {
        itemList.get(0).findElement(By.className("btn_inventory")).click(); // Assuming we add the first item to the cart
    }

    public boolean isButtonChanged(String expectedButtonText) {
        String actualButtonText = itemButton.getText();
        return actualButtonText.equals(expectedButtonText);
    }

    public boolean isCartIconDisplayed() {
        return cartIcon.isDisplayed();
    }
}
