package com.tubes.websaucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

<<<<<<< HEAD

    @FindBy(id = "checkout")
    private WebElement checkoutButton;


=======
>>>>>>> be05f7f8e0a77e9755751524d24872c57d2e8b76
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

<<<<<<< HEAD
    public void clickCheckout() {
        checkoutButton.click();
    }

=======
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
               itemName.isDisplayed() && itemDescription.isDisplayed() && itemPrice.isDisplayed();
    }
>>>>>>> be05f7f8e0a77e9755751524d24872c57d2e8b76
}
