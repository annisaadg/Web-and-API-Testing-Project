package com.tubes.websaucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(css = "span.title[data-test='title']")
    private WebElement title;

    @FindBy(css = "button[data-test='continue-shopping']")
    private WebElement continueShoppingButton;

    @FindBy(css = "button[data-test='checkout']")
    private WebElement checkoutButton;

    @FindBy(css = "button[data-test='add-to-cart-sauce-labs-backpack']")
    private WebElement addToCartButton;

    @FindBy(css = "button[data-test='remove-sauce-labs-backpack']")
    private WebElement removeButton;

    @FindBy(css = "div[data-test='inventory-item-name']")
    private WebElement itemName;

    @FindBy(css = "div[data-test='inventory-item-desc']")
    private WebElement itemDescription;

    @FindBy(css = "div[data-test='inventory-item-price']")
    private WebElement itemPrice;

    public void clickCartIcon() {
        cartIcon.click();
    }

    public String getTitle() {
        return title.getText();
    }

    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public String getItemName() {
        return itemName.getText();
    }

    public String getItemDescription() {
        return itemDescription.getText();
    }

    public String getItemPrice() {
        return itemPrice.getText();
    }

    // Metode untuk memeriksa elemen pada halaman keranjang kosong
    public boolean isEmptyCartDisplayed() {
        return title.isDisplayed() && continueShoppingButton.isDisplayed() && checkoutButton.isDisplayed();
    }

    // Metode untuk memeriksa elemen pada halaman keranjang yang berisi barang
    public boolean isCartWithItemsDisplayed() {
        return title.isDisplayed() && continueShoppingButton.isDisplayed() && checkoutButton.isDisplayed() &&
               itemName.isDisplayed() && itemDescription.isDisplayed() && itemPrice.isDisplayed() && removeButton.isDisplayed();
    }
}
