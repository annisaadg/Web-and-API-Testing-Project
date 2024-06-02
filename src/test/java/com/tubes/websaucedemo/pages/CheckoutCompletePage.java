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

    @FindBy(className="complete-text")
    private WebElement description;

    @FindBy(id="back-to-products")
    private WebElement backHomeButton;

    public void clickBackHomeButton() {
        backHomeButton.click();
    }

    public boolean isCheckoutCompletePageCorrect(String expectedPageTitle, String expectedRemark, String expectedDesc, String expectedButton) {
        
        boolean isBackHomeButtonDisplayed = backHomeButton.isDisplayed();
            
        if (!(isBackHomeButtonDisplayed)) {
            System.out.println("Back Home button is not displayed");
            return false;
        }

        String actualPageTitle = pageTitle.getText();
        String actualRemark = remark.getText();
        String actualDescription = description.getText();
        String actualButton = backHomeButton.getText();

        return actualPageTitle.equals(expectedPageTitle) && actualRemark.equals(expectedRemark) && actualDescription.equals(expectedDesc) && actualButton.equals(expectedButton);
    }

    
}

