package com.tubes.websaucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    public CheckoutCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(className="title")
    private WebElement pageTitle;

    @FindBy(className="complete-header")
    private WebElement remark;

    @FindBy(id="back-to-products")
    private WebElement backHomeButton;

    public void clickBackHomeButton() {
        backHomeButton.click();
    }

    public boolean isCheckoutCompletePageCorrect(String expectedPageTitle, String expectedRemark, String expectedButton) {
        
        boolean isBackHomeButtonDisplayed = backHomeButton.isDisplayed();
            
        if (!(isBackHomeButtonDisplayed)) {
            return false;
        }

        String actualPageTitle = pageTitle.getText();
        String actualRemark = remark.getText();
        String actualButton = backHomeButton.getText();

        return actualPageTitle.equals(expectedPageTitle) && actualRemark.equals(expectedRemark) && actualButton.equals(expectedButton);
    }

    
}

