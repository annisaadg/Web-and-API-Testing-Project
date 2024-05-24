package com.tubes.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(css=".error-message-container.error")
    public WebElement errorMessage;

    public void enterUsername(String usrname) {
        username.sendKeys(usrname);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        String actualErrorMessage = errorMessage.getText();
        return actualErrorMessage;
    }
}