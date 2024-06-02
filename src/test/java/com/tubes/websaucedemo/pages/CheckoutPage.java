package com.tubes.websaucedemo.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    
    @FindBy(id="first-name")
    private WebElement firstName;

    @FindBy(id="last-name")
    private WebElement lastName;

    @FindBy(id="postal-code")
    private WebElement postalCode;

    @FindBy(id="continue")
    private WebElement continueButton;

    @FindBy(className="title")
    private WebElement pageTitle;

    @FindBy(className = "cart_list")
    private List<WebElement> cartList;

    @FindBy(css = "[data-test='payment-info-label']")
    private WebElement paymentInfoLabel;

    @FindBy(css = "[data-test='payment-info-value']")
    private WebElement paymentInfoValue;

    @FindBy(css = "[data-test='shipping-info-label']")
    private WebElement shippingInfoLabel;

    @FindBy(css = "[data-test='shipping-info-value']")
    private WebElement shippingInfoValue;

    @FindBy(className="summary_subtotal_label")
    private WebElement subtotal;

    @FindBy(className="summary_tax_label")
    private WebElement tax;

    @FindBy(className="summary_total_label")
    private WebElement total;

    @FindBy(id="finish")
    private WebElement finishButton;

    @FindBy(id="cancel")
    private WebElement cancelButton;


    public void enterFirstName(String frstName) {
        firstName.sendKeys(frstName);
    }

    public void enterLastName(String lstName) {
        lastName.sendKeys(lstName);
    }

    public void enterPostalCode(String zipCode) {
        postalCode.sendKeys(zipCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }


    public boolean isPageTitleCorrect(String expectedPageTitle) {
        String actualPageTitle = pageTitle.getText();
        return actualPageTitle.equals(expectedPageTitle);
    }

    public boolean isItemBoughtDisplayed() {
        for (WebElement itemBought : cartList) {
            boolean isNameDisplayed = itemBought.findElement(By.className("inventory_item_name")).isDisplayed();
            boolean isDescriptionDisplayed = itemBought.findElement(By.className("inventory_item_desc")).isDisplayed();
            boolean isPriceDisplayed = itemBought.findElement(By.className("inventory_item_price")).isDisplayed();
            
            if (!(isNameDisplayed && isDescriptionDisplayed && isPriceDisplayed)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInformationDisplayed(String expectedPaymentInfo, String expectedShippingInfo) {

        boolean isPaymentInfoDisplayed = paymentInfoLabel.isDisplayed();
        boolean isShippingInfoDisplayed = paymentInfoLabel.isDisplayed();
            
        if (!(isPaymentInfoDisplayed && isShippingInfoDisplayed)) {
            return false;
        }

        String actualPaymentInfoValue = paymentInfoValue.getText();
        String actualShippingInfoValue = shippingInfoValue.getText();

        return actualPaymentInfoValue.equals(expectedPaymentInfo) && actualShippingInfoValue.equals(expectedShippingInfo);
    }

    public boolean isTotalPriceDisplayed() {

        boolean isSubtotalDisplayed = subtotal.isDisplayed();
        boolean isTaxDisplayed = tax.isDisplayed();
        boolean isTotalDisplayed = total.isDisplayed();
            
        if (!(isSubtotalDisplayed && isTaxDisplayed && isTotalDisplayed)) {
            return false;
        }

        return true;
    }

    public boolean isButtonDisplayed() {

        boolean isFinishButtonDisplayed = finishButton.isDisplayed();
        boolean isCancelButtonDisplayed = cancelButton.isDisplayed();

        if (!(isFinishButtonDisplayed && isCancelButtonDisplayed)) {
            return false;
        }

        return true;

    }
    
}

