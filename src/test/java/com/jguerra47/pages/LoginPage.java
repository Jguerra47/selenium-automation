package com.jguerra47.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement inputUsername;
    @FindBy(id = "password")
    WebElement inputPassword;
    @FindBy(id = "login-button")
    WebElement buttonLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void login() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonLogin)).click();
    }
}
